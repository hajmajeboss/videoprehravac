package cz.hajma.videoplayer.viewmodels

import androidx.lifecycle.*
import cz.hajma.videoplayer.R
import cz.hajma.videoprehravac.domain.dto.Filter
import cz.hajma.videoprehravac.domain.useCases.FilterUseCase
import cz.hajma.videoprehravac.domain.useCases.GetVideoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val getVideoUseCase: GetVideoListUseCase,
    val filterUseCase: FilterUseCase,
) : ViewModel() {

    var videoListUnfiltered : List<VideoListItemViewModel> = listOf()

    val videoList: LiveData<List<VideoListItemViewModel>>
        get() = _data
    private var _data = MutableLiveData<List<VideoListItemViewModel>>(emptyList())

    val searchQuery : MutableLiveData<String>
        get() = _searchQuery
    private var _searchQuery = MutableLiveData<String>()

    val drmActive : MutableLiveData<Boolean>
        get() = _drmActive
    private var _drmActive = MutableLiveData<Boolean>(true)

    val mp4Active : MutableLiveData<Boolean>
        get() = _mp4Active
    private var _mp4Active = MutableLiveData<Boolean>(true)

    val hlsActive : MutableLiveData<Boolean>
        get() = _hlsActive
    private var _hlsActive = MutableLiveData<Boolean>(true)

    val dashActive : MutableLiveData<Boolean>
        get() = _dashActive
    private var _dashActive = MutableLiveData<Boolean>(true)

    val webmActive : MutableLiveData<Boolean>
        get() = _webmActive
    private var _webmActive = MutableLiveData<Boolean>(true)

    val chipsMediator : MediatorLiveData<Filter>
        get() = _chipsMediator
    private var _chipsMediator = MediatorLiveData<Filter>()

    var filter : Filter = Filter(query = null, drm = true, mp4 = true, hls = true, dash = true, webM = true)

    init {
        loadData()

    /*    chipsMediator.addSource(drmActive) {
            chipsMediator.value?.drm = it
        }

        chipsMediator.addSource(mp4Active) {
            chipsMediator.value?.mp4 = it
        }

        chipsMediator.addSource(hlsActive) {
            chipsMediator.value?.hls = it
        }

        chipsMediator.addSource(dashActive) {
            chipsMediator.value?.dash = it
        }

        chipsMediator.addSource(webmActive) {
            chipsMediator.value?.webM = it
        }
        */
    }

    private fun loadData() {
        // This is a coroutine scope with the lifecycle of the ViewModel
        viewModelScope.launch {
            var res = getVideoUseCase.invoke()?.toList()?.map { video -> VideoListItemViewModel(video) }
            if (res != null) {
                videoListUnfiltered = res
            }
            _data.postValue(videoListUnfiltered)
        }

        _drmActive.postValue(true)
    }

    fun filterData(filter : Filter?) {
        if (filter != null) {
            var filteredData = videoListUnfiltered
            if (filter.query != null && !filter.query.isNullOrEmpty()) {
                filteredData = filteredData.filter {
                    it.dto.name?.lowercase()?.contains(filter.query?.lowercase()!!) == true
                }
            }
            if (!filter.drm)
                filteredData = filteredData.filter {
                    it.dto.licenseServers == null || (it.dto.licenseServers?.comMicrosoftPlayready == null
                            && it.dto.licenseServers?.comWidevineAlpha == null
                            && it.dto.licenseServers?.orgW3Clearkey == null)
                }

            _data.postValue(filteredData)
        }
    }
}
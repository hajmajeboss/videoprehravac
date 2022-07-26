package cz.hajma.videoplayer.viewmodels

import android.util.Log
import androidx.lifecycle.*
import cz.hajma.videoprehravac.domain.dto.Filter
import cz.hajma.videoprehravac.domain.dto.VideoItem
import cz.hajma.videoprehravac.domain.enums.SortOrder
import cz.hajma.videoprehravac.domain.useCases.FilterUseCase
import cz.hajma.videoprehravac.domain.useCases.GetVideoListUseCase
import cz.hajma.videoprehravac.domain.useCases.SortUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for MainActivity.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    val getVideoUseCase: GetVideoListUseCase,
    val filterUseCase : FilterUseCase,
    var sortUseCase: SortUseCase
    ) : ViewModel() {

    var videoListUnfiltered: List<VideoItem> = listOf()

    val videoList: LiveData<List<VideoListItemViewModel>>
        get() = _data
    private var _data = MutableLiveData<List<VideoListItemViewModel>>(emptyList())

    val searchQuery: MutableLiveData<String>
        get() = _searchQuery
    private var _searchQuery = MutableLiveData<String>()

    val drmActive: MutableLiveData<Boolean>
        get() = _drmActive
    private var _drmActive = MutableLiveData<Boolean>(false)

    val sdActive: MutableLiveData<Boolean>
        get() = _sdActive
    private var _sdActive = MutableLiveData<Boolean>(true)

    val hdActive: MutableLiveData<Boolean>
        get() = _hdActive
    private var _hdActive = MutableLiveData<Boolean>(true)

    val uhdActive: MutableLiveData<Boolean>
        get() = _uhdActive
    private var _uhdActive = MutableLiveData<Boolean>(true)

    val liveActive: MutableLiveData<Boolean>
        get() = _liveActive
    private var _liveActive = MutableLiveData<Boolean>(false)

    val subtitlesActive: MutableLiveData<Boolean>
        get() = _subtitlesActive
    private var _subtitlesActive = MutableLiveData<Boolean>(true)

    var filter: Filter =
        Filter(query = null, drm = false, sd = true, hd = true, uhd = true, live = false, subtitles = true)

    var sortOrder : SortOrder = SortOrder.DATE_DESC

    init {
        loadData()
    }

    /**
     * Loads data from the internet or from the database.
     */
    private fun loadData() {
        viewModelScope.launch {
            var res = getVideoUseCase.invoke()
            res.fold({ Log.e("ERR", it.messages.joinToString() + it.exception?.message + it.exception?.stackTraceToString())}, {videoListUnfiltered = it})
           filterData(filter)
        }
    }

    /**
     * Filters data based on Filter object properties.
     */
    fun filterData(filter: Filter?) {
        var dataFiltered = sortUseCase.invoke(filterUseCase.invoke(videoListUnfiltered, filter), sortOrder)
        _data.postValue(dataFiltered.map { video -> VideoListItemViewModel(video) })
    }

    /**
     * Sorts data based on parameter.
     */
    fun sortData(order : SortOrder) {
        sortOrder = order
        filterData(filter);
    }

}
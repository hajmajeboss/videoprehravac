package cz.hajma.videoplayer.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.hajma.videoprehravac.domain.useCases.GetVideoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val getVideoUseCase : GetVideoListUseCase) : ViewModel() {

    val videoList: LiveData<List<VideoListItemViewModel>>
        get() = _data
    private val _data = MutableLiveData<List<VideoListItemViewModel>>(emptyList())


    init {
        loadData()
    }

    private fun loadData() {
        // This is a coroutine scope with the lifecycle of the ViewModel
        viewModelScope.launch {

            _data.postValue(getVideoUseCase.invoke()?.toList()?.map { video -> VideoListItemViewModel(video) })
        }
    }
}
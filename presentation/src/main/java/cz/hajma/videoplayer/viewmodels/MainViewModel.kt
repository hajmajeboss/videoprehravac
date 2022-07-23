package cz.hajma.videoplayer.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.hajma.videoprehravac.data.model.Video
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    val videoList: LiveData<List<VideoListItemViewModel>>
        get() = _data
    private val _data = MutableLiveData<List<VideoListItemViewModel>>(emptyList())


    init {
        loadData()
    }

    private fun loadData() {
        // This is a coroutine scope with the lifecycle of the ViewModel
        viewModelScope.launch {
            val video = VideoListItemViewModel(Video("Test", "Testovací video", 140.0))
            _data.postValue(listOf(video))
        }
    }
}
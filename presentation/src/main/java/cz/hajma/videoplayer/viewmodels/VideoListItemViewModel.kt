package cz.hajma.videoplayer.viewmodels

import androidx.lifecycle.ViewModel
import cz.hajma.videoprehravac.data.dto.VideoListDto

class VideoListItemViewModel(val dto : VideoListDto) : ViewModel() {
    var lengthText : String = dto.length.toString() + " s"
}
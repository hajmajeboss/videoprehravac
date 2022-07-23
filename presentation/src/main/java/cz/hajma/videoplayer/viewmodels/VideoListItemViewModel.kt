package cz.hajma.videoplayer.viewmodels

import androidx.lifecycle.ViewModel
import cz.hajma.videoprehravac.domain.dto.VideoItem

class VideoListItemViewModel(val dto : VideoItem) : ViewModel() {
    var lengthText : String = dto.storedContent?.duration.toString() + " s"
}
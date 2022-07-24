package cz.hajma.videoplayer.viewmodels

import androidx.lifecycle.ViewModel
import cz.hajma.videoprehravac.domain.dto.VideoItem
import kotlin.math.roundToInt

class VideoListItemViewModel(val dto : VideoItem) : ViewModel() {
    var lengthText : String = if (dto.storedContent?.duration != null) " " + dto.storedContent?.duration?.roundToInt().toString() + " s " else ""
}
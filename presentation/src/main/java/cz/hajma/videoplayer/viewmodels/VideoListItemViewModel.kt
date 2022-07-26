package cz.hajma.videoplayer.viewmodels

import androidx.lifecycle.ViewModel
import cz.hajma.videoprehravac.domain.dto.VideoItem
import kotlin.math.roundToInt

/**
 * ViewModel for Video list item.
 * Provides only one-way binding, so no live data is needed here.
 */
class VideoListItemViewModel(val dto : VideoItem) : ViewModel() {
    var lengthText : String = if (dto.storedContent?.duration != null) " " + dto.storedContent?.duration?.roundToInt().toString() + " s " else ""
    var hasDrm : Boolean = !(dto.licenseServers == null || (dto.licenseServers?.comMicrosoftPlayready == null
            && dto.licenseServers?.comWidevineAlpha == null
            && dto.licenseServers?.orgW3Clearkey == null))
}
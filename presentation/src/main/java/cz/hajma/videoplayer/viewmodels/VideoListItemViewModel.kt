package cz.hajma.videoplayer.viewmodels

import androidx.lifecycle.ViewModel
import cz.hajma.videoprehravac.domain.dto.VideoItem
import cz.hajma.videoprehravac.domain.enums.DrmEnum
import cz.hajma.videoprehravac.domain.enums.Feature
import kotlin.math.roundToInt

/**
 * ViewModel for Video list item.
 * Provides only one-way binding, so no live data is needed here.
 */
class VideoListItemViewModel(val dto : VideoItem) : ViewModel() {
    var hasDrm : Boolean = dto.drm?.contains(DrmEnum.DEMO_CLEAR) == false

    var isHd : Boolean = dto.features?.contains(Feature.DEMO_HIGH_DEFINITION) == true
            || dto.features?.contains(Feature.DEMO_ULTRA_HIGH_DEFINITION) == true

    val resolutionText : String
        get() {
            if (dto.features?.contains(Feature.DEMO_HIGH_DEFINITION) == true) return "HD"
            else if (dto.features?.contains(Feature.DEMO_ULTRA_HIGH_DEFINITION) == true) return "4K"
            else return "SD"
        }

    var isLive : Boolean = dto.features?.contains(Feature.DEMO_LIVE) == true
}
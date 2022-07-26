package cz.hajma.videoprehravac.domain.useCases

import cz.hajma.videoprehravac.domain.dto.Filter
import cz.hajma.videoprehravac.domain.dto.VideoItem
import cz.hajma.videoprehravac.domain.enums.DrmEnum
import cz.hajma.videoprehravac.domain.enums.Feature
import javax.inject.Inject

/**
 * Use case - filtering entries
 */
class FilterUseCase @Inject constructor() {
    /**
     * Invokes the use case - filters a presented list using a Filter object.
     */
    fun invoke(videoListUnfiltered : List<VideoItem>, filter : Filter?) : List<VideoItem> {
        if (filter != null) {
            var filteredData = videoListUnfiltered
            if (filter.query != null && !filter.query.isNullOrEmpty()) {
                filteredData = filteredData.filter {
                    it.name?.lowercase()?.replace(" ", "")?.contains(filter.query?.lowercase()!!) == true
                }
            }
            if (!filter.drm) {
                filteredData = filteredData.filter {
                    it.drm?.contains(DrmEnum.DEMO_CLEAR) == true
                }
            }
            if (!filter.sd) {
                filteredData = filteredData.filter {
                    (it.features?.contains(Feature.DEMO_HIGH_DEFINITION) == true
                            || it.features?.contains(Feature.DEMO_ULTRA_HIGH_DEFINITION) == true)
                }
            }
            if (!filter.hd) {
                filteredData = filteredData.filterNot {
                    it.features?.contains(Feature.DEMO_HIGH_DEFINITION) == true
                }
            }
            if (!filter.uhd) {
                filteredData = filteredData.filterNot {
                    it.features?.contains(Feature.DEMO_ULTRA_HIGH_DEFINITION) == true
                }
            }
            if (filter.live) {
                filteredData = filteredData.filter {
                    it.features?.contains(Feature.DEMO_LIVE) == true
                }
            }
            if (!filter.subtitles) {
                filteredData = filteredData.filterNot {
                    it.features?.contains(Feature.DEMO_SUBTITLES) == true
                }
            }
            return filteredData
        }
        return videoListUnfiltered
    }
}
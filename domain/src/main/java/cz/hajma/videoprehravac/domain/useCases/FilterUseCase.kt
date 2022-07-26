package cz.hajma.videoprehravac.domain.useCases

import cz.hajma.videoprehravac.domain.dto.Filter
import cz.hajma.videoprehravac.domain.dto.VideoItem
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
                    it.name?.lowercase()?.contains(filter.query?.lowercase()!!) == true
                }
            }
            if (!filter.drm) {
                filteredData = filteredData.filter {
                    it.licenseServers == null || (it.licenseServers.comMicrosoftPlayready == null
                            && it.licenseServers.comWidevineAlpha == null
                            && it.licenseServers.orgW3Clearkey == null)
                }
            }
            if (!filter.sd) {
                filteredData = filteredData.filter {
                    (it.features?.contains(Feature.DEMO_HIGH_DEFINITION) == true
                            || it.features?.contains(Feature.DEMO_ULTRA_HIGH_DEFINITION) == true)
                }
            }
            if (!filter.hd) {
                filteredData = filteredData.filter {
                    it.features?.contains(Feature.DEMO_HIGH_DEFINITION) == false
                }
            }
            if (!filter.uhd) {
                filteredData = filteredData.filter {
                    it.features?.contains(Feature.DEMO_ULTRA_HIGH_DEFINITION) == false
                }
            }
            if (filter.live) {
                filteredData = filteredData.filter {
                    it.features?.contains(Feature.DEMO_LIVE) == true
                }
            }
            if (!filter.subtitles) {
                filteredData = filteredData.filter {
                    it.features?.contains(Feature.DEMO_SUBTITLES) == false
                }
            }
            return filteredData
        }
        return videoListUnfiltered
    }
}
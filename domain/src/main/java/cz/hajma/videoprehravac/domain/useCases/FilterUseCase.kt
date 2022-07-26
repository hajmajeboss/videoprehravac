package cz.hajma.videoprehravac.domain.useCases

import cz.hajma.videoprehravac.domain.dto.Filter
import cz.hajma.videoprehravac.domain.dto.VideoItem
import cz.hajma.videoprehravac.domain.enums.DrmEnum
import cz.hajma.videoprehravac.domain.enums.Feature
import java.util.function.Predicate
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

            var filteringPredicate = Predicate<VideoItem> {true}

            // Local variable with smart cast needed to avoid using "!!"
            val query = filter.query?.lowercase()
            if (query != null && !query.isNullOrEmpty()) filteringPredicate = filteringPredicate.and {
                    it.name?.lowercase()?.replace(" ", "")?.contains(query) == true }

            if (!filter.drm) filteringPredicate = filteringPredicate.and {
                    it.drm?.contains(DrmEnum.DEMO_CLEAR) == true }

            if (!filter.sd) filteringPredicate = filteringPredicate.and {
                    (it.features?.contains(Feature.DEMO_HIGH_DEFINITION) == true
                            || it.features?.contains(Feature.DEMO_ULTRA_HIGH_DEFINITION) == true) }

            if (!filter.hd) filteringPredicate = filteringPredicate.and {
                    it.features?.contains(Feature.DEMO_HIGH_DEFINITION) == false }

            if (!filter.uhd) filteringPredicate = filteringPredicate.and {
                    it.features?.contains(Feature.DEMO_ULTRA_HIGH_DEFINITION) == false }

            if (filter.live) filteringPredicate = filteringPredicate.and {
                    it.features?.contains(Feature.DEMO_LIVE) == true }

            if (!filter.subtitles) filteringPredicate = filteringPredicate.and {
                    it.features?.contains(Feature.DEMO_SUBTITLES) == false }

            return videoListUnfiltered.filter {filteringPredicate.test(it) }
        }
        return videoListUnfiltered
    }
}
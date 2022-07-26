package cz.hajma.videoprehravac.domain.useCases

import cz.hajma.videoprehravac.domain.dto.VideoItem
import cz.hajma.videoprehravac.domain.enums.SortOrder
import javax.inject.Inject

/**
 * Use case - Sorting video list
 */
class SortUseCase @Inject constructor() {
    /**
     * Invokes the use case
     */
    fun invoke(listUnsorted : List<VideoItem>, order : SortOrder) : List<VideoItem> {
        return when(order) {
            SortOrder.ALPHABETICAL -> listUnsorted.sortedBy { x -> x.name }
            SortOrder.DATE_ASC -> listUnsorted.asReversed()
            SortOrder.DATE_DESC -> listUnsorted
        }
    }
}
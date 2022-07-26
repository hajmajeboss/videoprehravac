package cz.hajma.videoprehravac.domain.useCases

import cz.hajma.videoprehravac.domain.dto.VideoItem
import cz.hajma.videoprehravac.domain.repositories.IVideoRepository
import javax.inject.Inject

/**
 * Use case - Get Video List
 */
class GetVideoListUseCase @Inject constructor(private val videoRepository : IVideoRepository) {
    /**
     * Invokes the use use case. Returns a list of videos from repository.
     */
    suspend fun invoke() : List<VideoItem>? {
        return videoRepository.getVideos()
    }
}
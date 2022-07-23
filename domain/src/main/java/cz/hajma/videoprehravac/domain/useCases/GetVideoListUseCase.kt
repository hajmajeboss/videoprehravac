package cz.hajma.videoprehravac.domain.useCases

import cz.hajma.videoprehravac.domain.dto.VideoItem
import cz.hajma.videoprehravac.domain.repositories.IVideoRepository
import javax.inject.Inject

class GetVideoListUseCase @Inject constructor(private val videoRepository : IVideoRepository) {
    suspend fun invoke() : List<VideoItem>? {
        return videoRepository.getVideos()
    }
}
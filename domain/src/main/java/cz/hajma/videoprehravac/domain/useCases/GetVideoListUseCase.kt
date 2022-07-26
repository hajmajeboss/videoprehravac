package cz.hajma.videoprehravac.domain.useCases

import arrow.core.Either
import arrow.core.left
import cz.hajma.videoprehravac.domain.dto.VideoItem
import cz.hajma.videoprehravac.domain.failures.BaseFailure
import cz.hajma.videoprehravac.domain.repositories.IVideoRepository
import java.lang.Exception
import javax.inject.Inject

/**
 * Use case - Get Video List
 */
class GetVideoListUseCase @Inject constructor(private val videoRepository : IVideoRepository) {
    /**
     * Invokes the use use case. Returns a list of videos from repository.
     */
    suspend fun invoke() : Either<BaseFailure, List<VideoItem>> {
        try {
            val ret = videoRepository.getVideos();
            if (ret != null) return Either.Right(ret)
            return Either.Left(BaseFailure(listOf("Error loading video")));
        }
        catch (e : Exception) {
            return Either.Left(BaseFailure(listOf("Error loading video"), e));
        }
    }
}
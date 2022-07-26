package cz.hajma.videoprehravac.domain.repositories

import cz.hajma.videoprehravac.domain.dto.VideoItem

/**
 * Interface for Video Entity repository.
 */
interface IVideoRepository {
    /**
     * Returns a list of Video entities.
     */
    suspend fun getVideos() : List<VideoItem>?
}


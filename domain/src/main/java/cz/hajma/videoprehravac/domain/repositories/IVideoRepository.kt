package cz.hajma.videoprehravac.domain.repositories

import cz.hajma.videoprehravac.domain.dto.Video
import cz.hajma.videoprehravac.domain.dto.VideoItem

interface IVideoRepository {
    suspend fun getVideos() : List<VideoItem>?
}


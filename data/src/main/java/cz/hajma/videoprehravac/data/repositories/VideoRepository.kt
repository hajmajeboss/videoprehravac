package cz.hajma.videoprehravac.data.repositories

import cz.hajma.videoprehravac.data.AppDatabase
import cz.hajma.videoprehravac.data.network.interfaces.VideoServiceInterface
import cz.hajma.videoprehravac.data.network.services.VideoService
import cz.hajma.videoprehravac.domain.dto.Video
import cz.hajma.videoprehravac.domain.dto.VideoItem
import cz.hajma.videoprehravac.domain.repositories.IVideoRepository

import javax.inject.Inject

class VideoRepository @Inject constructor(private val database : AppDatabase, private val videoService : VideoService) :
    IVideoRepository {
    suspend override fun getVideos() : List<VideoItem>? {
        val api = videoService.getClient()?.create(VideoServiceInterface::class.java)
        var list = api?.getList()
        return list
    }
}


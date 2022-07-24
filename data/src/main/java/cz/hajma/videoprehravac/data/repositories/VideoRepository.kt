package cz.hajma.videoprehravac.data.repositories

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import cz.hajma.videoprehravac.data.AppDatabase
import cz.hajma.videoprehravac.data.adapters.MoshiArrayListAdapter
import cz.hajma.videoprehravac.data.entities.VideoEntity
import cz.hajma.videoprehravac.data.network.interfaces.VideoServiceInterface
import cz.hajma.videoprehravac.data.network.services.VideoService
import cz.hajma.videoprehravac.domain.dto.VideoItem
import cz.hajma.videoprehravac.domain.repositories.IVideoRepository
import java.util.*

import javax.inject.Inject

class VideoRepository @Inject constructor(private val database : AppDatabase, private val videoService : VideoService) :
    IVideoRepository {
    suspend override fun getVideos() : List<VideoItem>? {
        val moshi = Moshi.Builder().add(MoshiArrayListAdapter()).build()
        val listMyData = Types.newParameterizedType(List::class.java, VideoItem::class.java)

        val jsonAdapter = moshi.adapter<List<VideoItem>>(listMyData);
        try {
            val api = videoService.getClient()?.create(VideoServiceInterface::class.java)
            var list = api?.getList()
            database.videoDao().insertAll(VideoEntity(1, jsonAdapter.toJson(list), Date().time))
            return list
        }
        catch (e : Exception) {
            try {
                val dbList = database.videoDao().getLastList().firstOrNull()
                if (dbList != null) {
                    return jsonAdapter.fromJson(dbList.data.toString());
                }
            }
            catch (dbE : Exception) {
                return listOf()
            }
        }
        return listOf()
    }
}

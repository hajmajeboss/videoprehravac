package cz.hajma.videoprehravac.data.network.interfaces

import cz.hajma.videoprehravac.domain.dto.VideoItem
import retrofit2.http.GET

/**
 * Service interface for VideoService.
 */
interface VideoServiceInterface {

    /**
     * Returns a list of videos from Video REST API.
     */
    @GET("nextsux/f6e0327857c88caedd2dab13affb72c1/raw/04441487d90a0a05831835413f5942d58026d321")
    suspend fun getList(): List<VideoItem>
}
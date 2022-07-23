package cz.hajma.videoprehravac.data.network.services

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Video REST API service.
 */
class VideoService {
    private var retrofit : Retrofit? = null

    fun getClient() : Retrofit? {
        retrofit = Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit;
    }
}
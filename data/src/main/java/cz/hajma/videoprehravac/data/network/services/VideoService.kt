package cz.hajma.videoprehravac.data.network.services

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Video REST API service.
 */
class VideoService {
    private var retrofit : Retrofit? = null

    /**
     * Returns a Retrofit Video REST API service client.
     * You need to call .create on the returned Retrofit object.
     */
    fun getClient() : Retrofit? {
        retrofit = Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit;
    }
}
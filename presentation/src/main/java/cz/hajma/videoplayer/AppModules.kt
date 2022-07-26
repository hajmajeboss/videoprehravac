package cz.hajma.videoplayer

import android.content.Context
import androidx.room.Room
import cz.hajma.videoprehravac.data.AppDatabase
import cz.hajma.videoprehravac.data.network.services.VideoService
import cz.hajma.videoprehravac.data.repositories.VideoRepository
import cz.hajma.videoprehravac.domain.repositories.IVideoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Dependency injection of interfaces or abstract classes is done here.
 */

@Module
@InstallIn(dagger.hilt.components.SingletonComponent::class)
class AppDatabaseModule {

    @Provides
    fun bindAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }
}

@Module
@InstallIn(dagger.hilt.components.SingletonComponent::class)
class VideoServiceModule {

    @Provides
    fun bindAppDatabase(): VideoService {
        return VideoService()
    }
}

@Module
@InstallIn(dagger.hilt.components.SingletonComponent::class)
abstract class VideoRepositoryModule {
    @Binds
    abstract fun bindAnalyticsService(
        videoRepositoryImpl: VideoRepository
    ): IVideoRepository
}


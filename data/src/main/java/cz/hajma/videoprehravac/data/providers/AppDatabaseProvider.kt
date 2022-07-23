package cz.hajma.videoprehravac.data.providers

import android.content.Context
import androidx.room.Room
import cz.hajma.videoprehravac.data.AppDatabase

class AppDatabaseProvider {
    fun getDatabase(ctx : Context) : AppDatabase {
        return Room.databaseBuilder(ctx,
            AppDatabase::class.java, "videos"
        ).build()
    }
}
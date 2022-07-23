package cz.hajma.videoprehravac.data

import androidx.room.Database
import androidx.room.RoomDatabase
import cz.hajma.videoprehravac.data.dao.VideoDao
import cz.hajma.videoprehravac.data.entities.Video

/**
 * Application database entry point.
 */
@Database(entities = [Video::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun videoDao(): VideoDao
}
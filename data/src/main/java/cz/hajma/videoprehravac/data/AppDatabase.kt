package cz.hajma.videoprehravac.data

import androidx.room.Database
import androidx.room.RoomDatabase
import cz.hajma.videoprehravac.data.dao.VideoDao
import cz.hajma.videoprehravac.data.entities.VideoEntity

/**
 * Application database entry point.
 */
@Database(entities = [VideoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    /**
     * Returns Video Data Access Object.
     */
    abstract fun videoDao(): VideoDao
}
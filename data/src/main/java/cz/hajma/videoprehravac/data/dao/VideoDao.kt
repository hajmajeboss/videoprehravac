package cz.hajma.videoprehravac.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cz.hajma.videoprehravac.data.entities.VideoEntity

/**
 * Video data access object.
 */
@Dao
interface VideoDao {

    /**
     * Inserts video(s).
     */
    @Insert
    fun insertAll(vararg videos : VideoEntity)

    /**
     * Returns a list of videos
     */
    @Query("select * from videoentity")
    fun getList() : List<VideoEntity>

    /**
     * Deletes all lists of videos.
     */
    @Query("delete from videoentity")
    fun deleteAll()
}
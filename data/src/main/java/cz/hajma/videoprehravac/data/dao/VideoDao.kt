package cz.hajma.videoprehravac.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import cz.hajma.videoprehravac.data.entities.Video

/**
 * Video data access object.
 */
@Dao
interface VideoDao {

    @Insert
    fun insertAll(vararg videos : Video)

    @Query("select * from video")
    fun getLastList() : List<Video>
}
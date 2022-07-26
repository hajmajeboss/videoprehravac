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

    @Insert
    fun insertAll(vararg videos : VideoEntity)

    @Query("select * from videoentity")
    fun getList() : List<VideoEntity>
}
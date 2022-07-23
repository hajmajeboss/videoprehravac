package cz.hajma.videoprehravac.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Video entity
 */
@Entity
data class VideoEntity (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "data") val data: String?,
    @ColumnInfo(name = "timestamp") val timestamp: Long)
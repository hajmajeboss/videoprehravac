package cz.hajma.videoprehravac.domain.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Track(
    val active: Boolean?,
    val audioBandwidth: Any?,
    val audioCodec: String?,
    val audioId: Int?,
    val audioMimeType: String,
    val audioRoles: List<Any>?,
    val audioSamplingRate: Any?,
    val bandwidth: Int?,
    val channelsCount: Any?,
    val codecs: String?,
    val forced: Boolean?,
    val frameRate: Int?,
    val hdr: Any?,
    val height: Int?,
    val id: Int?,
    val kind: Any?,
    val label: String?,
    val language: String?,
    val mimeType: String?,
    val originalAudioId: Any?,
    val originalImageId: Any?,
    val originalTextId: Any?,
    val originalVideoId: Any?,
    val pixelAspectRatio: Any?,
    val primary: Boolean?,
    val roles: List<Any>?,
    val spatialAudio: Boolean?,
    val tilesLayout: Any?,
    val type: String?,
    val videoBandwidth: Any?,
    val videoCodec: String?,
    val videoId: Int?,
    val videoMimeType: String?,
    val width: Int?
)
package cz.hajma.videoprehravac.domain.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StoredContent(
    val appMetadata: AppMetadata?,
    val duration: Double?,
    val expiration: Any?,
    val isIncomplete: Boolean?,
    val offlineUri: String?,
    val originalManifestUri: String?,
    val size: Int?,
    val tracks: List<Track>?
)
package cz.hajma.videoprehravac.domain.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AppMetadata(
    val downloaded: String?,
    val identifier: String?
)
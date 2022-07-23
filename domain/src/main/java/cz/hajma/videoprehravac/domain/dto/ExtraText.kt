package cz.hajma.videoprehravac.domain.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExtraText(
    val kind: String?,
    val language: String?,
    val mime: String?,
    val uri: String?
)
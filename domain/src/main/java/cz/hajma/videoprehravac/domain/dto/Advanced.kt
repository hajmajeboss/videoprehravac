package cz.hajma.videoprehravac.domain.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Advanced(
    @Json(name = "com.widevine.alpha") val comWidevineAlpha: ComWidevineAlpha?
)
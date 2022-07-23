package cz.hajma.videoprehravac.domain.dto

import com.squareup.moshi.Json

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LicenseServers(

    @Json(name = "com.microsoft.playready") val comMicrosoftPlayready: String?,
    @Json(name = "com.widevine.alpha") val comWidevineAlpha: String?,
    @Json(name = "org.w3.clearkey") val orgW3Clearkey: String?
)
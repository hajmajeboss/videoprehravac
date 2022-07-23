package cz.hajma.videoprehravac.domain.dto

import com.squareup.moshi.Json

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LicenseRequestHeaders(
    @Json(name = "X-AxDRM-Message") val XAxDrmMessage: String?
)
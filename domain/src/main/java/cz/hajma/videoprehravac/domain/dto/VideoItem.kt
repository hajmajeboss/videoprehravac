package cz.hajma.videoprehravac.domain.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VideoItem(
    val adTagUri: String?,
    val certificateUri: Any?,
    val clearKeys: ClearKeys?,
    val description: String?,
    val disabled: Boolean?,
    val drm: List<String>?,
    val extraConfig: ExtraConfig?,
    val extraText: List<ExtraText>?,
    val features: List<String>?,
    val focus: Boolean?,
    val iconUri: String?,
    val imaAssetKey: String?,
    val imaContentSrcId: Int?,
    val imaVideoId: String?,
    val isFeatured: Boolean?,
    val licenseRequestHeaders: LicenseRequestHeaders?,
    val licenseServers: LicenseServers?,
    val manifestUri: String?,
    val mediaPlaylistFullMimeType: String?,
    val mimeType: Any?,
    val name: String?,
    val requestFilter: Any?,
    val responseFilter: Any?,
    val shortName: String?,
    val source: String?,
    val storedContent: StoredContent?,
    val storedProgress: Int?
)
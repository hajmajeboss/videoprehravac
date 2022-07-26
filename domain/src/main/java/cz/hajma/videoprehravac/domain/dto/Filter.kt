package cz.hajma.videoprehravac.domain.dto

/**
 * Filter
 * Is used to filter video list entries based on query or properties.
 */
data class Filter(
    var query : String?,
    var drm : Boolean,
    var sd : Boolean,
    var hd : Boolean,
    var uhd : Boolean,
    var live : Boolean,
    var subtitles: Boolean) {
}
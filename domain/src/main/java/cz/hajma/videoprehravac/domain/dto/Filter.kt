package cz.hajma.videoprehravac.domain.dto

/**
 * Filter
 * Is used to filter video list entries based on query or properties.
 */
data class Filter(
    var query : String?,
    var drm : Boolean,
    var mp4 : Boolean,
    var hls : Boolean,
    var dash : Boolean,
    var webM : Boolean) {
}
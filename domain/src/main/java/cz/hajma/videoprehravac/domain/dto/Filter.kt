package cz.hajma.videoprehravac.domain.dto

data class Filter(
    var query : String?,
    var drm : Boolean,
    var mp4 : Boolean,
    var hls : Boolean,
    var dash : Boolean,
    var webM : Boolean) {
}
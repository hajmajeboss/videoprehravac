package cz.hajma.videoprehravac.data.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import cz.hajma.videoprehravac.domain.dto.VideoItem

/**
 * Moshi ArrayList Adapter
 * Handles parsing from/to ArrayList to/from JSON
 */
class MoshiArrayListAdapter {
    /**
     * Parses ArrayList to JSON.
     */
    @ToJson
    fun arrayListToJson(list: ArrayList<VideoItem>): List<VideoItem> = list

    /**
     * Parses JSON to ArrayList.
     */
    @FromJson
    fun arrayListFromJson(list: List<VideoItem>): ArrayList<VideoItem> = ArrayList(list)
}
package cz.hajma.videoprehravac.data.adapters

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import cz.hajma.videoprehravac.domain.dto.VideoItem

class MoshiArrayListAdapter {
    @ToJson
    fun arrayListToJson(list: ArrayList<VideoItem>): List<VideoItem> = list

    @FromJson
    fun arrayListFromJson(list: List<VideoItem>): ArrayList<VideoItem> = ArrayList(list)
}
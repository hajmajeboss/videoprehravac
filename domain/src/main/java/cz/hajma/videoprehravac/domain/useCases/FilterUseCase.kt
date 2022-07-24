package cz.hajma.videoprehravac.domain.useCases

import cz.hajma.videoprehravac.domain.dto.VideoItem
import javax.inject.Inject

class FilterUseCase @Inject constructor() {
    fun filter(list : List<VideoItem>, query : String) : List<VideoItem> {
        var ret : List<VideoItem>
        ret = list.filter { it.name?.contains(query) == true }
      //  ret = ret.filter { it.licenseServers?.comMicrosoftPlayready != null || it.licenseServers?.comWidevineAlpha != null || it.licenseServers?.orgW3Clearkey != null  }
        return ret
    }
}
package cz.hajma.videoplayer.adapters

import android.net.Uri
import android.view.View
import androidx.databinding.BindingAdapter
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.norulab.exofullscreen.preparePlayer
import cz.hajma.videoprehravac.domain.dto.VideoItem


@BindingAdapter("videoUri")
fun loadImage(view: View, video: VideoItem?) {
    val image: PlayerView = view as PlayerView

    var player = SimpleExoPlayer.Builder(view.context).build()
    player.preparePlayer(image, false)
    image.setPlayer(player)
    player.setMediaItem(MediaItem.fromUri((Uri.parse(video?.manifestUri))))
    player.prepare()
    image.controllerAutoShow = false;
    image.hideController()
}
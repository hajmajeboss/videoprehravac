package cz.hajma.videoplayer.activities

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.StyledPlayerView
import cz.hajma.videoplayer.R

/**
 * Simple video player activity. Video URI is passed by Extras.
 * Should be a fragment with navigation (androidx.navigation:navigation).
 */
class VideoPlayerActivity : AppCompatActivity() {
    var player : ExoPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_videoplayer)

        var uri = intent.extras?.getString("url")
        var video = findViewById<StyledPlayerView>(R.id.videoplayer_video)
        player = ExoPlayer.Builder(this).build()
        video.setPlayer(player)
        player?.setMediaItem(MediaItem.fromUri((Uri.parse(uri))))
        player?.prepare()
        player?.play()
    }

    override fun onPause() {
        player?.pause()
        super.onPause()
    }

    override fun onDestroy() {
        player?.stop()
        super.onDestroy()
    }
}
package cz.hajma.videoplayer.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(view: View,
              imageUrl: String?) {
    val image: ImageView = view as ImageView
    Glide.with(image.context)
        .load(imageUrl)
        .into(image)
}
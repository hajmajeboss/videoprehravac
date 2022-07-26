package cz.hajma.videoplayer.adapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Binding adapter used to bind ImageURI to ImageView and load it using Glide.
 */
@BindingAdapter("imageUri")
fun loadImage(view: View,
              imageUrl: String?) {
    val image: ImageView = view as ImageView
    Glide.with(image.context)
        .load(imageUrl)
        .into(image)
}
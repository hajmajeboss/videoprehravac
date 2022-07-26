package cz.hajma.videoplayer.adapters

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.databinding.BindingAdapter

/**
 * Adapter used to bind Visibility to a View.
 */
@BindingAdapter("visibility")
fun setVisibility(view: View, value : Boolean) {
    view.visibility = if (value) VISIBLE else GONE
}
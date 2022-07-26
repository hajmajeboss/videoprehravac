package cz.hajma.videoplayer.adapters

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import cz.hajma.videoplayer.viewmodels.VideoListItemViewModel

/**
 * Adapter used for binding itemViewModels to a RecyclerView.
 */
@BindingAdapter("itemViewModels")
fun bindItemViewModels(recyclerView: RecyclerView, itemViewModels: LiveData<List<VideoListItemViewModel>>?) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateItems(itemViewModels?.value)
}

private fun getOrCreateAdapter(recyclerView: RecyclerView): VideoListAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is VideoListAdapter) {
        recyclerView.adapter as VideoListAdapter
    } else {
        val bindableRecyclerAdapter = VideoListAdapter()
        recyclerView.adapter = bindableRecyclerAdapter
        bindableRecyclerAdapter
    }
}
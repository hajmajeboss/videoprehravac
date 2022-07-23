package cz.hajma.videoplayer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import cz.hajma.videoplayer.BR
import cz.hajma.videoplayer.R
import cz.hajma.videoplayer.viewmodels.VideoListItemViewModel

class VideoListAdapter : RecyclerView.Adapter<VideoListViewHolder>() {
    var itemViewModels : List<VideoListItemViewModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoListViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.listitem_video,
            parent,
            false)
        return VideoListViewHolder(binding)    }

    override fun onBindViewHolder(holder: VideoListViewHolder, position: Int) {
        holder.bind(itemViewModels[position])
    }

    override fun getItemCount(): Int {
        return itemViewModels.count()
    }

    fun updateItems(items: List<VideoListItemViewModel>?) {
        itemViewModels = items ?: emptyList()
        notifyDataSetChanged()
    }
}

class VideoListViewHolder(private val binding : ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemViewModel : VideoListItemViewModel) {
        binding.setVariable(BR.itemViewModel, itemViewModel)
    }
}
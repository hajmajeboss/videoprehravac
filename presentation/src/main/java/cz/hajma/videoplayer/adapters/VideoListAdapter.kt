package cz.hajma.videoplayer.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import cz.hajma.videoplayer.BR
import cz.hajma.videoplayer.R
import cz.hajma.videoplayer.activities.VideoPlayerActivity
import cz.hajma.videoplayer.viewmodels.VideoListItemViewModel

/**
 * Video list RecyclerView adapter.
 * Could be parametrized (onCreateViewHolder viewType : Int parameter) and used for almost every RecyclerView providing bindable data.
 */
class VideoListAdapter : RecyclerView.Adapter<VideoListViewHolder>() {
    var itemViewModels : List<VideoListItemViewModel> = emptyList()
    private var onClickListener : View.OnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoListViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.listitem_video,
            parent,
            false)
        return VideoListViewHolder(binding)    }

    override fun onBindViewHolder(holder: VideoListViewHolder, position: Int) {
        holder.bind(itemViewModels[position])
        holder.itemView.setOnClickListener {
            var intent = Intent(holder.itemView.context, VideoPlayerActivity::class.java)
            intent.putExtra("url", itemViewModels[position].dto.manifestUri)
            holder.itemView.context.startActivity(intent)
        }
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
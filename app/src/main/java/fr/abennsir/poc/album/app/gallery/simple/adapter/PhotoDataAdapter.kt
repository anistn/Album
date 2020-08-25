package fr.abennsir.poc.album.app.gallery.simple.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import fr.abennsir.poc.album.R
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.viewholder.AlbumRecyclerViewHolder
import fr.abennsir.poc.album.app.gallery.viewholder.ThumbnailRecyclerViewHolder


/**
 * Adapter for the list of photo.
 */
class PhotoDataAdapter(private val clickAction: (UiModel.PhotoItem, Int) -> Unit) :
    ListAdapter<UiModel, ViewHolder>(
        UI_MODEL_COMPARATOR
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == R.layout.grid_photo_item) {
            ThumbnailRecyclerViewHolder.create(
                parent
            )
        } else {
            AlbumRecyclerViewHolder.create(
                parent
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is UiModel.PhotoItem -> R.layout.grid_photo_item
            is UiModel.AlbumItem -> R.layout.album_view_item
            null -> throw UnsupportedOperationException("Unknown view")
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val uiModel = getItem(position)
        uiModel.let {
            when (uiModel) {
                is UiModel.PhotoItem -> (holder as ThumbnailRecyclerViewHolder).bind(
                    uiModel,
                    clickAction
                )
                is UiModel.AlbumItem -> (holder as AlbumRecyclerViewHolder).bind(uiModel.title)
            }
        }
    }

    companion object {
        private val UI_MODEL_COMPARATOR = object : DiffUtil.ItemCallback<UiModel>() {
            override fun areItemsTheSame(oldItem: UiModel, newItem: UiModel): Boolean {
                return (oldItem is UiModel.PhotoItem && newItem is UiModel.PhotoItem &&
                        oldItem.id == newItem.id) ||
                        (oldItem is UiModel.AlbumItem && newItem is UiModel.AlbumItem &&
                                oldItem.title == newItem.title)
            }

            override fun areContentsTheSame(oldItem: UiModel, newItem: UiModel): Boolean =
                oldItem == newItem
        }
    }
}
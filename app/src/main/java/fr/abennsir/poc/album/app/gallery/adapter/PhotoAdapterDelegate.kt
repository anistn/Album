package fr.abennsir.poc.album.app.gallery.adapter


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import fr.abennsir.poc.album.R
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.viewholder.AlbumRecyclerViewHolder
import fr.abennsir.poc.album.app.gallery.viewholder.ThumbnailRecyclerViewHolder

/**
 * Delegate class to be used with List/Paging Adapter
 */
class PhotoAdapterDelegate(private val clickAction: (UiModel.PhotoItem, Int) -> Unit) :
    IBaseAdapter<UiModel, RecyclerView.ViewHolder> {

    companion object {
        val UI_MODEL_COMPARATOR = object : DiffUtil.ItemCallback<UiModel>() {
            override fun areItemsTheSame(oldItem: UiModel, newItem: UiModel): Boolean {
                return (oldItem is UiModel.PhotoItem && newItem is UiModel.PhotoItem && oldItem.id == newItem.id) || (oldItem is UiModel.AlbumItem && newItem is UiModel.AlbumItem && oldItem.id == newItem.id)
            }

            override fun areContentsTheSame(oldItem: UiModel, newItem: UiModel): Boolean =
                oldItem == newItem
        }
    }

    override lateinit var getItemForPosition: (Int) -> UiModel?

    override fun getItemViewType(position: Int): Int {
        return when (getItemForPosition(position)) {
            is UiModel.PhotoItem -> R.layout.grid_photo_item
            is UiModel.AlbumItem -> R.layout.album_view_item
            null -> throw UnsupportedOperationException("Unknown view")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val uiModel = getItemForPosition(position)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == R.layout.grid_photo_item) {
            ThumbnailRecyclerViewHolder.create(parent)
        } else {
            AlbumRecyclerViewHolder.create(parent)
        }
    }
}
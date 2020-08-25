package fr.abennsir.poc.album.app.gallery.adapter


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import fr.abennsir.poc.album.R
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.viewholder.PhotoGalleryRecyclerViewHolder

/**
 * Base implementation for Adapter of Carousel.
 */
class PhotoGalleryAdapterDelegate :
    IBaseAdapter<UiModel.PhotoItem, PhotoGalleryRecyclerViewHolder> {

    companion object {
        val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<UiModel.PhotoItem>() {
            override fun areItemsTheSame(
                oldItem: UiModel.PhotoItem,
                newItem: UiModel.PhotoItem
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: UiModel.PhotoItem,
                newItem: UiModel.PhotoItem
            ): Boolean = oldItem == newItem
        }
    }

    override lateinit var getItemForPosition: (Int) -> UiModel.PhotoItem?

    override fun getItemViewType(position: Int): Int = R.layout.gallery_photo_item
    override fun onBindViewHolder(holder: PhotoGalleryRecyclerViewHolder, position: Int) {
        getItemForPosition.invoke(position)
            ?.let {
                holder.bind(it)
            }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGalleryRecyclerViewHolder = PhotoGalleryRecyclerViewHolder.create(
        parent
    )
}
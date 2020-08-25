package fr.abennsir.poc.album.app.gallery.simple.adapter


import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import fr.abennsir.poc.album.R

import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.viewholder.PhotoGalleryRecyclerViewHolder


/**
 * Adapter for the gallery of photo, will be used with view pager
 */
class PhotoGalleryDataAdapter :
    ListAdapter<UiModel.PhotoItem, PhotoGalleryRecyclerViewHolder>(PHOTO_COMPARATOR) {

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

    override fun getItemViewType(position: Int): Int = R.layout.gallery_photo_item
    override fun onBindViewHolder(holder: PhotoGalleryRecyclerViewHolder, position: Int) {
        getItem(position)
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
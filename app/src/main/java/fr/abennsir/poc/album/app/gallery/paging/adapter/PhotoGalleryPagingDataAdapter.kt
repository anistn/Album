package fr.abennsir.poc.album.app.gallery.paging.adapter

import androidx.paging.PagingDataAdapter
import fr.abennsir.poc.album.app.gallery.adapter.IBaseAdapter
import fr.abennsir.poc.album.app.gallery.adapter.PhotoGalleryAdapterDelegate
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.viewholder.PhotoGalleryRecyclerViewHolder

/**
 * Adapter for the gallery of photo, will be used with view pager
 */
class PhotoGalleryPagingDataAdapter(private val delegate: PhotoGalleryAdapterDelegate) :
    PagingDataAdapter<UiModel.PhotoItem, PhotoGalleryRecyclerViewHolder>(PhotoGalleryAdapterDelegate.PHOTO_COMPARATOR),
    IBaseAdapter<UiModel.PhotoItem, PhotoGalleryRecyclerViewHolder> by delegate {
    init {
        delegate.getItemForPosition = this::getItem
    }

    override fun getItemViewType(position: Int): Int {
        return delegate.getItemViewType(position)
    }
}
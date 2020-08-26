package fr.abennsir.poc.album.app.gallery.simple.adapter


import androidx.recyclerview.widget.ListAdapter
import fr.abennsir.poc.album.app.gallery.adapter.IBaseAdapter
import fr.abennsir.poc.album.app.gallery.adapter.PhotoGalleryAdapterDelegate
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.viewholder.PhotoGalleryRecyclerViewHolder


/**
 * Adapter for the gallery of photo, will be used with view pager
 */
class PhotoGalleryDataAdapter(private val delegate: PhotoGalleryAdapterDelegate) :
    ListAdapter<UiModel.PhotoItem, PhotoGalleryRecyclerViewHolder>(PhotoGalleryAdapterDelegate.PHOTO_COMPARATOR),
    IBaseAdapter<UiModel.PhotoItem, PhotoGalleryRecyclerViewHolder> by delegate {

    init {
        delegate.getItemForPosition = this::getItem
    }

    override fun getItemViewType(position: Int): Int {
        return delegate.getItemViewType(position)
    }

}
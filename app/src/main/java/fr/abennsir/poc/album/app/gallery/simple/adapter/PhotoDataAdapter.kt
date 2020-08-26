package fr.abennsir.poc.album.app.gallery.simple.adapter

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import fr.abennsir.poc.album.app.gallery.adapter.IBaseAdapter
import fr.abennsir.poc.album.app.gallery.adapter.PhotoAdapterDelegate
import fr.abennsir.poc.album.app.gallery.data.UiModel


/**
 * Adapter for the list of photo.
 */

/**
 * Adapter for the list of photo.
 */
class PhotoDataAdapter(private val delegate: PhotoAdapterDelegate) :
    ListAdapter<UiModel, ViewHolder>(PhotoAdapterDelegate.UI_MODEL_COMPARATOR),
    IBaseAdapter<UiModel, ViewHolder> by delegate {
    init {
        delegate.getItemForPosition = this::getItem
    }

    override fun getItemViewType(position: Int): Int {
        return delegate.getItemViewType(position)
    }
}
package fr.abennsir.poc.album.app.gallery.paging.adapter


import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.abennsir.poc.album.app.gallery.adapter.IBaseAdapter
import fr.abennsir.poc.album.app.gallery.adapter.PhotoAdapterDelegate
import fr.abennsir.poc.album.app.gallery.adapter.PhotoAdapterDelegate.Companion.UI_MODEL_COMPARATOR
import fr.abennsir.poc.album.app.gallery.data.UiModel

/**
 * Adapter for the list of photo.
 */
class PhotoPagingDataAdapter(private val delegate: PhotoAdapterDelegate) :
    PagingDataAdapter<UiModel, RecyclerView.ViewHolder>(UI_MODEL_COMPARATOR),
    IBaseAdapter<UiModel, RecyclerView.ViewHolder> by delegate {
    init {
        delegate.getItemForPosition = this::getItem
    }

    override fun getItemViewType(position: Int): Int {
        return delegate.getItemViewType(position)
    }
}
package fr.abennsir.poc.album.app.gallery.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import fr.abennsir.poc.album.R
import fr.abennsir.poc.album.app.core.tools.loadThumbnail
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.domain.data.Photo


/**
 * View Holder for a [Photo] used on RecyclerView.
 */
class ThumbnailRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val imageView: ImageView = view.findViewById(R.id.photo)

    fun bind(photo: UiModel.PhotoItem, action: (photo: UiModel.PhotoItem, position: Int) -> Unit) {
        imageView.loadThumbnail(
            photo.thumbnailUrl, R.drawable.ic_photo_place_holder,
            R.drawable.ic_photo_place_holder_error_broken
        )
        imageView.setOnClickListener { _ ->
            action.invoke(photo, bindingAdapterPosition)
        }
    }


    companion object {
        fun create(parent: ViewGroup): ThumbnailRecyclerViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_photo_item, parent, false)
            return ThumbnailRecyclerViewHolder(view)
        }
    }
}

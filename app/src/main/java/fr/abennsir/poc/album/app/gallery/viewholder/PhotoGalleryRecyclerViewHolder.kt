package fr.abennsir.poc.album.app.gallery.viewholder


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.abennsir.poc.album.R
import fr.abennsir.poc.album.app.core.tools.loadGalleryImage
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.databinding.GalleryPhotoItemBinding
import fr.abennsir.poc.album.domain.data.Photo


/**
 * View Holder for a [Photo] used on RecyclerView.
 */
class PhotoGalleryRecyclerViewHolder(private val binding: GalleryPhotoItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(uiModel: UiModel.PhotoItem) {
        binding.photoView.loadGalleryImage(
            uiModel.url, R.drawable.ic_photo_place_holder_gallery,
            R.drawable.ic_photo_place_holder_error_broken_gallery
        )
        binding.description.text = uiModel.title
    }


    companion object {
        fun create(parent: ViewGroup): PhotoGalleryRecyclerViewHolder {
            val binding = GalleryPhotoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )

            return PhotoGalleryRecyclerViewHolder(binding)
        }
    }
}

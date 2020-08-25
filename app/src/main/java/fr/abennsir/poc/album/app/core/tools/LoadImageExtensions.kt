package fr.abennsir.poc.album.app.core.tools

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy

const val DEFAULT_THUMBNAIL_SIZE = 150
const val DEFAULT_IMAGE_SIZE = 600


fun ImageView.loadSizedImage(
    url: String?,
    @DrawableRes placeholder: Int,
    @DrawableRes errorDrawable: Int = placeholder,
    width: Int, height: Int
) {

    if (url == null || url.isEmpty()) {
        setImageResource(placeholder)
    } else {
        Glide.with(context)
            .load(url)
            .override(width, height)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .priority(Priority.LOW)
            .placeholder(placeholder)
            .error(errorDrawable)
            .into(this)
    }
}

fun ImageView.loadGalleryImage(
    url: String?,
    @DrawableRes placeholder: Int,
    @DrawableRes errorDrawable: Int = placeholder,
    width: Int = DEFAULT_IMAGE_SIZE, height: Int = DEFAULT_IMAGE_SIZE
) =
    loadSizedImage(url, placeholder, errorDrawable, width, height)

fun ImageView.loadThumbnail(
    url: String?,
    @DrawableRes placeholder: Int,
    @DrawableRes errorDrawable: Int = placeholder,
    width: Int = DEFAULT_THUMBNAIL_SIZE, height: Int = DEFAULT_THUMBNAIL_SIZE
) = loadSizedImage(url, placeholder, errorDrawable, width, height)
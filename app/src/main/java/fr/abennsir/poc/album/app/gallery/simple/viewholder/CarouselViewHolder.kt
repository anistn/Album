package fr.abennsir.poc.album.app.gallery.simple.viewholder


import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import fr.abennsir.poc.album.app.gallery.adapter.PhotoGalleryAdapterDelegate
import fr.abennsir.poc.album.app.gallery.data.NavigationMode
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.simple.adapter.PhotoGalleryDataAdapter
import fr.abennsir.poc.album.app.gallery.simple.viewmodel.PhotoViewModel
import fr.abennsir.poc.album.app.gallery.viewholder.BaseCarouselViewHolder
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * class to show photo carousel. It's used to show Gallery from [ListAdapter]
 * It manage show /scroll to target.
 * It's scoped to the Fragment/Activity holder.
 */
@ExperimentalCoroutinesApi
class CarouselViewHolder(
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: PhotoViewModel,
    galleryPager: ViewPager2,
    navigationMode: NavigationMode = NavigationMode.DEFAULT,
    onPageChanged: (UiModel.PhotoItem, Int) -> Unit = { _, _ -> Unit }

) : BaseCarouselViewHolder<PhotoGalleryDataAdapter>(
    galleryPager,
    onPageChanged,
    PhotoGalleryDataAdapter(delegate = PhotoGalleryAdapterDelegate()).apply {
        stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
    },
    navigationMode
) {

    override val currentListProducer: () -> List<UiModel.PhotoItem>
        get() = recyclerAdapter::getCurrentList

    init {
        initialize()
    }


    override fun observeData() {
        viewModel.getPhotosStream().observe(owner = lifecycleOwner) { items ->
            val list: List<UiModel.PhotoItem> = items.filterIsInstance<UiModel.PhotoItem>()
            recyclerAdapter.submitList(list)
            executePendingScroll()
        }
    }
}









package fr.abennsir.poc.album.app.gallery.paging.viewholder

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import fr.abennsir.poc.album.app.gallery.adapter.PhotoGalleryAdapterDelegate
import fr.abennsir.poc.album.app.gallery.data.NavigationMode
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.paging.adapter.PhotoGalleryPagingDataAdapter
import fr.abennsir.poc.album.app.gallery.paging.viewmodel.PagedPhotoViewModel
import fr.abennsir.poc.album.app.gallery.viewholder.BaseCarouselViewHolder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * class to show photo carousel. It's used to show Carousel from [PagingDataAdapter]
 * It manage show /scroll to target.
 * It's scoped to the Fragment/Activity holder.
 */
@ExperimentalCoroutinesApi
class PagedCarouselViewHolder(
    galleryPager: ViewPager2,
    navigationMode: NavigationMode = NavigationMode.DEFAULT,
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: PagedPhotoViewModel,
    onPageChanged: (UiModel.PhotoItem, Int) -> Unit = { _, _ -> Unit }

) : BaseCarouselViewHolder<PhotoGalleryPagingDataAdapter>(
    galleryPager, onPageChanged,
    PhotoGalleryPagingDataAdapter(delegate = PhotoGalleryAdapterDelegate()).apply {
        stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }, navigationMode
) {

    override val currentListProducer: () -> List<UiModel.PhotoItem>
        get() = {
            recyclerAdapter.snapshot().items
        }

    init {
        initialize()
    }

    override fun observeData() {
        lifecycleOwner.lifecycleScope.launch {
            viewModel.observePhotosStream()
                .collectLatest {
                    recyclerAdapter.submitData(it)
                    executePendingScroll()
                }
        }
    }
}
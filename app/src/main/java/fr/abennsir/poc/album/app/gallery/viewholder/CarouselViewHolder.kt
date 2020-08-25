package fr.abennsir.poc.album.app.gallery.viewholder


import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import fr.abennsir.poc.album.app.gallery.adapter.PhotoGalleryDataAdapter
import fr.abennsir.poc.album.app.gallery.data.NavigationMode
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.viewmodel.PhotoViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * class to show photo carousel. It's used to show Gallery from [ListAdapter]
 * It manage show /scroll to target.
 * It's scoped to the Fragment/Activity holder.
 */
@ExperimentalCoroutinesApi
class CarouselViewHolder(
    private val galleryPager: ViewPager2,
    private val navigationMode: NavigationMode = NavigationMode.DEFAULT,
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: PhotoViewModel,
    private val onPageChanged: (UiModel.PhotoItem, Int) -> Unit = { _, _ -> Unit }

) : BaseCarouselViewHolder<PhotoGalleryDataAdapter>(
    galleryPager, onPageChanged,
    PhotoGalleryDataAdapter().apply {
        stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
    }, navigationMode
) {

    override val currentListProducer: () -> List<UiModel.PhotoItem>
        get() = recyclerAdapter::getCurrentList

    init {
        initialize()
    }


    override fun observeData() {
        viewModel.photoLiveData.observe(lifecycleOwner) { items ->
            val list: List<UiModel.PhotoItem> = items.filterIsInstance<UiModel.PhotoItem>()
            recyclerAdapter.submitList(list)
            executePendingScroll()
        }
    }
}









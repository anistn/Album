package fr.abennsir.poc.album.app.gallery.viewholder


import androidx.annotation.CallSuper
import androidx.annotation.MainThread
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import fr.abennsir.poc.album.R
import fr.abennsir.poc.album.app.gallery.data.NavigationMode
import fr.abennsir.poc.album.app.gallery.data.UiModel

abstract class BaseCarouselViewHolder<out T : RecyclerView.Adapter<*>>(
    private val galleryPager: ViewPager2,
    private val onPageChanged: (UiModel.PhotoItem, Int) -> Unit = { _, _ -> Unit },
    recyclerAdapter: T, navigationMode: NavigationMode = NavigationMode.DEFAULT
) :
    AbstractScrollHandlerViewHolder<T>(
        navigationMode = navigationMode,
        recyclerAdapter = recyclerAdapter
    ) {

    abstract val currentListProducer: () -> List<UiModel.PhotoItem>

    fun initialize() {
        initViewPager()
        observeData()
    }

    protected abstract fun observeData()


    @CallSuper
    @MainThread
    protected fun initViewPager() {
        galleryPager.apply {
            adapter = recyclerAdapter
            setPageTransformer(
                MarginPageTransformer(resources.getDimensionPixelSize(R.dimen.margin_smaller))
            )
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    val currentPhoto = currentListProducer()[position]
                    onPageChanged(currentPhoto, position)
                }
            })
        }
    }

    override fun findTargetPosition(id: Long): Int? =
        currentListProducer().indexOfFirst { item: UiModel -> item is UiModel.PhotoItem && item.id == id }

    override fun executeEffectiveScroll(position: Int) {
        galleryPager.post {
            galleryPager.setCurrentItem(position, false)
        }
    }
}
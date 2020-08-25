package fr.abennsir.poc.album.app.gallery.viewholder


import androidx.annotation.CallSuper
import androidx.annotation.DrawableRes
import androidx.annotation.MainThread
import androidx.annotation.StringRes
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import fr.abennsir.poc.album.R
import fr.abennsir.poc.album.app.core.ui.SpaceItemDecoration
import fr.abennsir.poc.album.app.gallery.data.NavigationMode
import fr.abennsir.poc.album.app.gallery.data.ScreenState
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.ui.PhotoItemViewTypeSpanSizeLookup
import fr.abennsir.poc.album.databinding.FragmentAlbumBinding

abstract class BaseAlbumScreenViewHolder<out T : RecyclerView.Adapter<*>>(
    private val binding: FragmentAlbumBinding,
    private val navigationMode: NavigationMode = NavigationMode.DEFAULT, recyclerAdapter: T
) :
    AbstractScrollHandlerViewHolder<T>(
        navigationMode = navigationMode,
        recyclerAdapter = recyclerAdapter
    ) {

    abstract val retryAction: () -> Unit
    abstract val synchronizeAction: () -> Unit
    abstract val currentListProducer: () -> List<UiModel>


    @MainThread
    fun initialize() {
        initRecycler()
        observeData()
    }

    @MainThread
    fun showError(errorMessage: String) {
        binding.emotionalText.text = errorMessage
        Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_SHORT)
            .show()
    }

    @MainThread
    @CallSuper
    protected fun initRecycler() {

        binding.retryButton.setOnClickListener {
            retryAction.invoke()
        }
        binding.swipeList.setOnRefreshListener {
            synchronizeAction.invoke()
        }




        binding.list.apply {
            val space = binding.list.resources.getDimensionPixelSize(R.dimen.margin_smallest)
            val decoration = SpaceItemDecoration(space)
            addItemDecoration(decoration)
            itemAnimator = null
            val spanCount = resources.getInteger(R.integer.grid_span_size)
            layoutManager = GridLayoutManager(binding.root.context, spanCount).apply {
                if (navigationMode == NavigationMode.SECTIONED) {
                    spanSizeLookup = PhotoItemViewTypeSpanSizeLookup(
                        adapter = recyclerAdapter,
                        spanCount = spanCount
                    )
                }
            }
        }


        binding.list.layoutManager
        binding.list.adapter = recyclerAdapter

    }


    /**
     * add here your implementation to observe ViewModel
     */
    abstract fun observeData()

    private fun updateUiForStateChange(
        showProgress: Boolean, showEmptyRetry: Boolean,
        showList: Boolean
    ) {
        binding.swipeList.isVisible = showList
        binding.emptyScreen.isVisible = showEmptyRetry
        binding.progressBar.isVisible = showProgress
    }

    private fun updateEmptyScreen(
        @DrawableRes imageResource: Int,
        @StringRes textRes: Int? = null
    ) {
        binding.emotionalImage.setImageResource(imageResource)
        textRes?.let { messageRes ->
            binding.emotionalText.apply {
                text = context.getString(messageRes)
            }
        }
    }

    override fun findTargetPosition(id: Long): Int? =
        currentListProducer().indexOfFirst { item: UiModel -> item is UiModel.PhotoItem && item.id == id }

    override fun executeEffectiveScroll(position: Int) {
        binding.list.post {
            binding.list.smoothScrollToPosition(position)
        }
    }

    @MainThread
    fun updateScreenForState(screenState: ScreenState) {
        when (screenState) {
            ScreenState.EMPTY -> {
                updateEmptyScreen(
                    R.drawable.ui_kit_ic_emotional_smile_neutral,
                    R.string.empty_screen_infos_message
                )
                updateUiForStateChange(
                    showProgress = false, showEmptyRetry = true,
                    showList = false
                )
            }
            ScreenState.EMPTY_ERROR -> {
                updateEmptyScreen(R.drawable.ui_kit_ic_emotional_smile_unhappy)
                updateUiForStateChange(
                    showProgress = false, showEmptyRetry = true,
                    showList = false
                )
            }
            ScreenState.LOADING -> updateUiForStateChange(
                showProgress = true,
                showEmptyRetry = false, showList = false
            )
            ScreenState.REFRESH, ScreenState.IDLE -> {
                updateUiForStateChange(
                    showProgress = false, showEmptyRetry = false,
                    showList = true
                )
            }
        }
        binding.swipeList.isRefreshing = screenState == ScreenState.REFRESH
    }
}

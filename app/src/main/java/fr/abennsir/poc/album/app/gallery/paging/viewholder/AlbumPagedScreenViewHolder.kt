package fr.abennsir.poc.album.app.gallery.paging.viewholder


import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.abennsir.poc.album.app.core.mapper.getPresentationMessage
import fr.abennsir.poc.album.app.gallery.adapter.PhotoAdapterDelegate
import fr.abennsir.poc.album.app.gallery.data.NavigationMode
import fr.abennsir.poc.album.app.gallery.data.ScreenState
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.paging.adapter.PhotoPagingDataAdapter
import fr.abennsir.poc.album.app.gallery.paging.viewmodel.PagedPhotoViewModel
import fr.abennsir.poc.album.app.gallery.viewholder.BaseAlbumScreenViewHolder
import fr.abennsir.poc.album.databinding.FragmentAlbumBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

/**
 * class to show photo gridlayout. It's used to show album from [PagingDataAdapter]
 * It manage show /scroll to target.
 * It's scoped to the Fragment/Activity holder.
 */
@ExperimentalCoroutinesApi
class AlbumPagedScreenViewHolder(
    private val binding: FragmentAlbumBinding,
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: PagedPhotoViewModel,
    private val navigationMode: NavigationMode = NavigationMode.DEFAULT,
    private val photoClickAction: (UiModel.PhotoItem, Int) -> Unit = { _, _ -> Unit }
) :
    BaseAlbumScreenViewHolder<PhotoPagingDataAdapter>(binding, navigationMode,
        PhotoPagingDataAdapter(
            delegate = PhotoAdapterDelegate { item: UiModel.PhotoItem, position: Int ->
                photoClickAction(item, position)
            }).apply {
            stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        }) {

    override val retryAction: () -> Unit
        get() = recyclerAdapter::retry
    override val synchronizeAction: () -> Unit
        get() = recyclerAdapter::refresh
    override val currentListProducer: () -> List<UiModel>
        get() = {
            recyclerAdapter.snapshot().items
        }

    init {
        initialize()
    }

    override fun observeData() {
        lifecycleOwner.lifecycleScope.launch {
            val source: Flow<PagingData<UiModel>> = if (navigationMode == NavigationMode.DEFAULT) {
                viewModel.observePhotosStream()
                    .filterIsInstance()
            } else {
                viewModel.getPhotosSectionedByAlbum()
            }
            source.collectLatest {
                recyclerAdapter.submitData(it)
                executePendingScroll()
            }
        }

        lifecycleOwner.lifecycleScope.launch {
            recyclerAdapter.loadStateFlow.filterNot { it.source.refresh is LoadState.Loading }
                .map { it.mediator?.refresh }
                .filterNotNull()
                .map { computeScreenStateForLoadState(it) }
                .distinctUntilChanged()
                .conflate()
                //                .debounce(500)
                .collectLatest { loadState ->
                    updateScreenForState(loadState)
                }
        }

        lifecycleOwner.lifecycleScope.launch {
            recyclerAdapter.loadStateFlow.map { it.refresh }
                .filterNotNull()
                .filterIsInstance<LoadState.Error>()
                .distinctUntilChanged()
                .collectLatest {
                    val errorMessage = "\uD83D\uDE28 Wooops: ${
                        it.error.getPresentationMessage(binding.list.context)
                    }"
                    showError(errorMessage)
                }
        }
    }

    private fun computeScreenStateForLoadState(loadState: LoadState): ScreenState {
        val isEmpty = recyclerAdapter.itemCount == 0
        return when (loadState) {
            is LoadState.NotLoading -> if (isEmpty) ScreenState.EMPTY else ScreenState.IDLE
            LoadState.Loading -> if (isEmpty) ScreenState.LOADING else ScreenState.REFRESH
            is LoadState.Error -> {
                if (isEmpty) ScreenState.EMPTY_ERROR else ScreenState.IDLE
            }
        }
    }
}
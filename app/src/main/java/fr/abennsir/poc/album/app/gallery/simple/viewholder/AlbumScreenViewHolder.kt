package fr.abennsir.poc.album.app.gallery.simple.viewholder

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import fr.abennsir.poc.album.app.gallery.adapter.PhotoAdapterDelegate
import fr.abennsir.poc.album.app.gallery.data.NavigationMode
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.simple.adapter.PhotoDataAdapter
import fr.abennsir.poc.album.app.gallery.simple.viewmodel.PhotoViewModel
import fr.abennsir.poc.album.app.gallery.viewholder.BaseAlbumScreenViewHolder
import fr.abennsir.poc.album.databinding.FragmentAlbumBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
class AlbumScreenViewHolder(
    binding: FragmentAlbumBinding,
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel: PhotoViewModel,
    private val navigationMode: NavigationMode = NavigationMode.DEFAULT,
    private val photoClickAction: (UiModel.PhotoItem, Int) -> Unit = { _, _ -> Unit }
) : BaseAlbumScreenViewHolder<PhotoDataAdapter>(binding, navigationMode, PhotoDataAdapter(
    delegate = PhotoAdapterDelegate { item: UiModel.PhotoItem, position: Int ->
        photoClickAction(item, position)
    }).apply {
    stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
}) {

    init {
        initialize()
    }

    override val retryAction: () -> Unit
        get() = viewModel::retry
    override val synchronizeAction: () -> Unit
        get() = viewModel::synchronize
    override val currentListProducer: () -> List<UiModel>
        get() = recyclerAdapter::getCurrentList


    override fun observeData() {
        viewModel.getPhotosStream().observe(owner = lifecycleOwner) { listPhotos ->
            if (navigationMode == NavigationMode.DEFAULT) {
                //navigation mode using position
                recyclerAdapter.submitList(
                    listPhotos.filterIsInstance(UiModel.PhotoItem::class.java)
                )
            } else {
                // navigationMode using Photo Id
                recyclerAdapter.submitList(listPhotos)
            }
            executePendingScroll()
        }

        viewModel.getScreenStateStream().observe(
            owner = lifecycleOwner,
            onChanged = ::updateScreenForState
        )
        viewModel.getErrorStream().observe<String>(owner = lifecycleOwner) {
            val errorMessage = "\uD83D\uDE28 Wooops:  $it"
            showError(errorMessage)
        }
    }

}
package fr.abennsir.poc.album.app.gallery.ui


import androidx.navigation.NavController
import androidx.navigation.NavDirections
import fr.abennsir.poc.album.app.core.utils.getAndRemoveFromBackStackEntry
import fr.abennsir.poc.album.app.gallery.data.Config
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.viewholder.AbstractScrollHandlerViewHolder

/**
 * Base interface to create navigation parameter for [fr.abennsir.poc.album.app.gallery.data.NavigationMode]
 */

const val SELECTED_POSITION_KEY = "selected_position_key"
const val SELECTED_PHOTO_ID_KEY = "selected_photo_id_key"

interface SelectItemNavigationRequestHandler {
    fun navigateToDetail(item: UiModel.PhotoItem, position: Int)
}

interface SelectedItemNavigationResultHandler {
    fun handleNavigateToItem()
}

abstract class NavigationHandler(protected val navController: NavController) :
    SelectItemNavigationRequestHandler, SelectedItemNavigationResultHandler {

    override fun navigateToDetail(item: UiModel.PhotoItem, position: Int) {
        val directions = createDirection(item, position)
        navController.navigate(directions)
    }

    protected abstract fun createDirection(item: UiModel.PhotoItem, position: Int): NavDirections

}

/**
 * [NavigationHandler] using position
 */
class PositionalNavigationHandler(
    private val config: Config,
    private val scrollHandlerViewHolder: AbstractScrollHandlerViewHolder<*>,
    navController: NavController
) : NavigationHandler(navController) {

    override fun createDirection(item: UiModel.PhotoItem, position: Int): NavDirections =
        AlbumFragmentDirections.actionAlbumFragmentToCarouselDetailFragment(
            configuration = config, selectedPositionKey = position
        )

    override fun handleNavigateToItem() {
        getAndRemoveFromBackStackEntry<Int>(navController, SELECTED_POSITION_KEY)?.let {
            scrollHandlerViewHolder.updateTargetPosition(it)
        }
    }
}

/**
 * Navigation handler using item id.
 */
class IdentifierNavigationHandler(
    private val config: Config,
    private val scrollHandlerViewHolder: AbstractScrollHandlerViewHolder<*>,
    navController: NavController
) : NavigationHandler(navController),
    SelectedItemNavigationResultHandler {


    override fun createDirection(item: UiModel.PhotoItem, position: Int): NavDirections =
        AlbumFragmentDirections.actionAlbumFragmentToCarouselDetailFragment(
            configuration = config, selectedPhotoIdKey = item.id
        )

    override fun handleNavigateToItem() {

        getAndRemoveFromBackStackEntry<Long>(navController, SELECTED_PHOTO_ID_KEY)?.let {
            scrollHandlerViewHolder.updateSelectedItemId(it)
        }
    }
}
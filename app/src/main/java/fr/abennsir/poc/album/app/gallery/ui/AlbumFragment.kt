package fr.abennsir.poc.album.app.gallery.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import fr.abennsir.poc.album.R
import fr.abennsir.poc.album.app.core.utils.autoCleared
import fr.abennsir.poc.album.app.gallery.data.NavigationMode
import fr.abennsir.poc.album.app.gallery.data.UiModel
import fr.abennsir.poc.album.app.gallery.paging.viewholder.AlbumPagedScreenViewHolder
import fr.abennsir.poc.album.app.gallery.paging.viewmodel.PagedPhotoViewModel
import fr.abennsir.poc.album.app.gallery.simple.viewholder.AlbumScreenViewHolder
import fr.abennsir.poc.album.app.gallery.simple.viewmodel.PhotoViewModel
import fr.abennsir.poc.album.app.gallery.viewholder.BaseAlbumScreenViewHolder
import fr.abennsir.poc.album.app.gallery.viewmodel.ViewModelFactory
import fr.abennsir.poc.album.app.injection.ApplicationDependenciesResolver
import fr.abennsir.poc.album.databinding.FragmentAlbumBinding
import fr.abennsir.poc.album.domain.interactor.PhotoUsesCase
import kotlinx.coroutines.ExperimentalCoroutinesApi


/**
 * A simple [Fragment] subclass used to show All photos on a Grid.
 * It use position or item id if sectioned to navigate to Detail .
 */
@ExperimentalCoroutinesApi
class AlbumFragment : Fragment() {

    private var binding: FragmentAlbumBinding by autoCleared()
    private val navigationArgs: AlbumFragmentArgs by navArgs()

    private lateinit var itemNavigationHandler: NavigationHandler
    private lateinit var viewHolder: BaseAlbumScreenViewHolder<*>

    private val viewModelFactory by lazy {
        ViewModelFactory(
            PhotoUsesCase(ApplicationDependenciesResolver.resolveSharedRepository()),
            requireActivity().application
        )
    }

    //ViewModel creation is lazy, depending on configuration only one ViewModel will be instantiated
    private val simpleViewModel: PhotoViewModel by navGraphViewModels(R.id.navigation_graph_album) {
        viewModelFactory
    }
    private val pagedViewModel: PagedPhotoViewModel by navGraphViewModels(R.id.navigation_graph_album) {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createViewHolder()
        createSelectedItemNavigation()
        itemNavigationHandler.handleNavigateToItem()
    }


    private fun createViewHolder() {
        viewHolder = if (navigationArgs.configuration.enablePaging) {
            //pagedViewHolder
            AlbumPagedScreenViewHolder(
                binding = binding,
                viewModel = pagedViewModel,
                navigationMode = navigationArgs.configuration.mode,
                lifecycleOwner = viewLifecycleOwner
            ) { uiData, position ->
                itemNavigationHandler.navigateToDetail(uiData, position)
            }
        } else {
            //simple ViewHolder
            AlbumScreenViewHolder(
                binding = binding,
                viewModel = simpleViewModel,
                navigationMode = navigationArgs.configuration.mode,
                lifecycleOwner = viewLifecycleOwner,
                photoClickAction = ::handleItemClickEvent
            )
        }
    }

    private fun handleItemClickEvent(item: UiModel.PhotoItem, position: Int) {
        itemNavigationHandler.navigateToDetail(item, position)
    }

    private fun createSelectedItemNavigation() {
        val navigationMode = navigationArgs.configuration.mode
        itemNavigationHandler = if (navigationMode == NavigationMode.DEFAULT) {
            PositionalNavigationHandler(
                config = navigationArgs.configuration,
                scrollHandlerViewHolder = viewHolder, navController = findNavController()
            )
        } else {
            IdentifierNavigationHandler(
                config = navigationArgs.configuration,
                scrollHandlerViewHolder = viewHolder, navController = findNavController()
            )
        }
    }
}
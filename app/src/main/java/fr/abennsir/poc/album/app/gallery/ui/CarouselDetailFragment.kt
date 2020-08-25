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
import fr.abennsir.poc.album.app.gallery.injection.ApplicationDependenciesResolver
import fr.abennsir.poc.album.app.gallery.simple.viewholder.CarouselViewHolder
import fr.abennsir.poc.album.app.gallery.viewholder.BaseCarouselViewHolder
import fr.abennsir.poc.album.app.gallery.viewmodel.PhotoViewModel
import fr.abennsir.poc.album.app.gallery.viewmodel.ViewModelFactory
import fr.abennsir.poc.album.databinding.FragmentCarouselDetailBinding
import fr.abennsir.poc.album.domain.interactor.PhotoUsesCase
import kotlinx.coroutines.ExperimentalCoroutinesApi


/**
 * A simple [Fragment] subclass ssed to show Pager for Photos.
 */

@ExperimentalCoroutinesApi
class CarouselDetailFragment : Fragment() {

    private var binding: FragmentCarouselDetailBinding by autoCleared()
    private val navigationArgs: CarouselDetailFragmentArgs by navArgs()

    private val viewModelFactory by lazy {
        ViewModelFactory(
            PhotoUsesCase(ApplicationDependenciesResolver.resolveSharedRepository()),
            requireActivity().application
        )
    }

    private val simpleViewModel: PhotoViewModel by navGraphViewModels(
        R.id.navigation_graph_album
    ) {
        viewModelFactory
    }
    private lateinit var viewHolder: BaseCarouselViewHolder<*>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarouselDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createViewHolder()

        if (savedInstanceState == null) {
            val configuration = navigationArgs.configuration
            if (configuration.mode == NavigationMode.DEFAULT) {
                viewHolder.updateTargetPosition(navigationArgs.selectedPositionKey)
            } else {
                viewHolder.updateSelectedItemId(navigationArgs.selectedPhotoIdKey)
            }
        }
    }


    private fun createViewHolder() {
        val configuration = navigationArgs.configuration
        viewHolder = if (navigationArgs.configuration.enablePaging) {
            TODO("Add paging implementation")

        } else {
            CarouselViewHolder(
                galleryPager = binding.galleryPager,
                navigationMode = configuration.mode, lifecycleOwner = viewLifecycleOwner,
                viewModel = simpleViewModel, onPageChanged = ::updateCurrentPage
            )
        }
    }

    private fun updateCurrentPage(item: UiModel.PhotoItem, position: Int) {
        val configuration = navigationArgs.configuration
        findNavController().previousBackStackEntry?.savedStateHandle?.apply {
            if (configuration.mode == NavigationMode.DEFAULT) {
                set(SELECTED_POSITION_KEY, position)
            } else {
                set(SELECTED_PHOTO_ID_KEY, item.id)
            }
        }
    }
}
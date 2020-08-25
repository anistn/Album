package fr.abennsir.poc.album.app.gallery.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import fr.abennsir.poc.album.app.core.utils.autoCleared
import fr.abennsir.poc.album.databinding.FragmentAlbumBinding


/**
 * A simple [Fragment] subclass used to show All photos on a Grid.
 * It use position or item id if sectioned to navigate to Detail .
 */
class AlbumFragment : Fragment() {

    private var binding: FragmentAlbumBinding by autoCleared()
    private val navigationArgs: AlbumFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("TAG", "ARGS ${navigationArgs.configuration}")
        binding.fakeBtn.setOnClickListener {
            findNavController().navigate(
                AlbumFragmentDirections.actionAlbumFragmentToCarouselDetailFragment(
                    configuration = navigationArgs.configuration,
                    selectedPhotoIdKey = 0,
                    selectedPositionKey = 0
                )
            )
        }

    }

}
package fr.abennsir.poc.album.app.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import fr.abennsir.poc.album.app.core.utils.autoCleared
import fr.abennsir.poc.album.app.gallery.data.Config
import fr.abennsir.poc.album.app.gallery.data.NavigationMode
import fr.abennsir.poc.album.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding by autoCleared()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startAlbum.setOnClickListener {

            val showAlbumSection = binding.activateAlbumSection.isChecked
            val config = Config(
                mode = if (showAlbumSection) NavigationMode.SECTIONED else NavigationMode.DEFAULT,
                enablePaging = binding.usePaging.isChecked
            )
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToNavigationGraphAlbum(configuration = config)
            )
        }
    }
}
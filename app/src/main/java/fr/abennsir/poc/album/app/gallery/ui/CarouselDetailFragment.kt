package fr.abennsir.poc.album.app.gallery.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import fr.abennsir.poc.album.app.core.utils.autoCleared
import fr.abennsir.poc.album.databinding.FragmentCarouselDetailBinding


/**
 * A simple [Fragment] subclass ssed to show Pager for Photos.
 */

class CarouselDetailFragment : Fragment() {

    private var binding: FragmentCarouselDetailBinding by autoCleared()
    private val navigationArgs: CarouselDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCarouselDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("TAG", "ARGS ${navigationArgs.configuration}")

    }
}
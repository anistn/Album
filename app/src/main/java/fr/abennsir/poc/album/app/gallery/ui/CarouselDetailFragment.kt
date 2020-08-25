package fr.abennsir.poc.album.app.gallery.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.abennsir.poc.album.R


/**
 * A simple [Fragment] subclass.
 * Use the [CarouselDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarouselDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_carousel_detail, container, false)
    }
}
package fr.abennsir.poc.album.app.gallery.ui

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.abennsir.poc.album.R

class PhotoItemViewTypeSpanSizeLookup(
    private val adapter: RecyclerView.Adapter<*>,
    private val spanCount: Int
) :
    GridLayoutManager.SpanSizeLookup() {
    init {
        isSpanIndexCacheEnabled = true
    }


    //this is used only for the demo, the call to getItemViewType with paging data consume a lot of CPU
    //            override fun getSpanSize(position: Int): Int =
    //                if (position == 0 || position.rem(51) == 0) {
    //                    manager.spanCount
    //                } else {
    //                    1
    //                }

    override fun getSpanSize(position: Int): Int {
        return when (adapter.getItemViewType(position)) {
            R.layout.grid_photo_item -> 1
            R.layout.album_view_item -> spanCount
            else -> spanCount
        }
    }
}
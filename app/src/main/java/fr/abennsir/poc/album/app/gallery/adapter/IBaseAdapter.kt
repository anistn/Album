package fr.abennsir.poc.album.app.gallery.adapter


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * Interface for base adapter.
 * This is needed since we use the same "Adapter" with different Inherited class base.
 */
interface IBaseAdapter<T : Any, VH : RecyclerView.ViewHolder> {

    var getItemForPosition: (Int) -> T?
    fun getItemViewType(position: Int): Int
    fun onBindViewHolder(holder: VH, position: Int)
    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH
}
package fr.abennsir.poc.album.app.gallery.viewholder


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.abennsir.poc.album.R

class AlbumRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val description: TextView = view.findViewById(R.id.title)

    fun bind(separatorText: String) {
        description.text = separatorText
    }

    companion object {
        fun create(parent: ViewGroup): AlbumRecyclerViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.album_view_item, parent, false)
            return AlbumRecyclerViewHolder(view)
        }
    }
}
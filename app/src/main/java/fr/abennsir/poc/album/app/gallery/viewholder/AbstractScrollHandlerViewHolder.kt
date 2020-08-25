package fr.abennsir.poc.album.app.gallery.viewholder


import androidx.recyclerview.widget.RecyclerView
import fr.abennsir.poc.album.app.gallery.data.NavigationMode

/**
 * ViewHolder with capability to manage scroll to position using position or id.
 */
abstract class AbstractScrollHandlerViewHolder<out T : RecyclerView.Adapter<*>>
    (
    private val navigationMode: NavigationMode = NavigationMode.DEFAULT,
    protected val recyclerAdapter: T
) {

    private var targetPhotoPosition = RecyclerView.NO_POSITION
    private var targetPhotoId = RecyclerView.NO_ID

    fun updateTargetPosition(position: Int) {
        if (position != targetPhotoPosition) {
            targetPhotoPosition = position
            executePendingScroll()
        }
    }

    fun updateSelectedItemId(id: Long) {
        if (targetPhotoId != id) {
            targetPhotoId = id
            executePendingScroll()
        }
    }

    fun executePendingScroll() {
        resolveTargetPosition()
        scrollToSelectedPositionIfNeeded()
    }

    private fun scrollToSelectedPositionIfNeeded() {
        if (targetPhotoPosition != RecyclerView.NO_POSITION && targetPhotoPosition < recyclerAdapter.itemCount) {
            val position = targetPhotoPosition
            executeEffectiveScroll(position)
            targetPhotoPosition = RecyclerView.NO_POSITION
            targetPhotoId = RecyclerView.NO_ID
        }
    }

    private fun resolveTargetPosition() {
        if (navigationMode == NavigationMode.SECTIONED && targetPhotoId != RecyclerView.NO_ID) {
            targetPhotoPosition = findTargetPosition(targetPhotoId) ?: RecyclerView.NO_POSITION
        }
    }

    /**
     * execute the scroll to the Scrollable ViewGroup
     */
    abstract fun executeEffectiveScroll(position: Int)

    /**
     * find the position for a given id.
     */
    abstract fun findTargetPosition(id: Long): Int?

}
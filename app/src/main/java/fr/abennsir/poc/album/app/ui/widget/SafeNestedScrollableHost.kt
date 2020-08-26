package fr.abennsir.poc.album.app.ui.widget


import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * This view Group is just used to avoid api limitation when using [com.github.chrisbanes.photoview.PhotoView]
 * For more information please refer to @see [PhotoView#issues-with-viewgroups] (https://github.com/chrisbanes/PhotoView#issues-with-viewgroups)
 */
class SafeNestedScrollableHost @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    NestedScrollableHost(context, attrs) {

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {

        return try {
            super.onInterceptTouchEvent(event)
        } catch (exception: IllegalArgumentException) {
            //uncomment if you really want to see these errors
            //e.printStackTrace();
            false
        }
    }
}
package ai.grant.viewswapper

import android.content.Context
import android.transition.Transition
import android.transition.TransitionManager
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import androidx.core.transition.doOnCancel
import androidx.core.transition.doOnEnd
import androidx.core.view.size

class ViewSwapper : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, @AttrRes defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun setInitialView(view: View) {
        if (size > 0) {
            throw RuntimeException("Initial view has already been set.")
        } else {
            addView(view)
        }
    }

    fun next(view: View, transition: Transition?) {
        if (transition == null) {
            removeAllViews()
            addView(view)
        } else {
            transition.doOnEnd { removePreviousView() }
            transition.doOnCancel { removePreviousView() }
            TransitionManager.beginDelayedTransition(this, transition)
            addView(view)
        }
    }

    private fun removePreviousView() {
        if (size > 1) {
            removeViewAt(0)
        }
    }
}
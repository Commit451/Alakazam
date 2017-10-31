package com.commit451.alakazam.kotlin

import android.view.View
import android.view.ViewPropertyAnimator
import com.commit451.alakazam.VisibilityRunnable


fun View.fadeOut(setAlphaToOne: Boolean = true, visibilityWhenComplete: Int = View.GONE): ViewPropertyAnimator {
    if (setAlphaToOne) {
        alpha = 1.0f
    }
    return animate()
            .alpha(0.0f)
            .withEndAction(VisibilityRunnable(this))
}

fun View.fadeIn(setAlphaToZero: Boolean = true): ViewPropertyAnimator {
    if (setAlphaToZero) {
        alpha = 0.0f
    }
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
    return animate()
            .alpha(1.0f)
}

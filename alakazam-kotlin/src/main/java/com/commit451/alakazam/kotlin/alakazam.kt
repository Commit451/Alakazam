package com.commit451.alakazam.kotlin

import android.view.View
import android.view.ViewPropertyAnimator
import com.commit451.alakazam.FadeInRunnable
import com.commit451.alakazam.HideRunnable


fun View.fadeOut(): ViewPropertyAnimator {
    return animate()
            .alpha(0.0f)
            .withEndAction(HideRunnable(this))
}

fun View.fadeIn() : ViewPropertyAnimator {
    return animate()
            .alpha(1.0f)
            .withStartAction(FadeInRunnable(this))
}

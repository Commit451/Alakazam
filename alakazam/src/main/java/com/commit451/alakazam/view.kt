package com.commit451.alakazam

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.drawable.ColorDrawable
import android.support.annotation.ColorInt
import android.view.View
import android.view.ViewPropertyAnimator
import com.commit451.alakazam.Alakazam.argbEvaluator

fun View.widthAnimator(currentWidth: Int, endWidth: Int): ValueAnimator {
    val anim = ValueAnimator.ofInt(currentWidth, endWidth)
    anim.addUpdateListener { valueAnimator ->
        val width = valueAnimator.animatedValue as Int
        val layoutParams = this.layoutParams
        layoutParams.width = width
        this.layoutParams = layoutParams
    }
    return anim
}

fun View.heightAnimator(currentHeight: Int, endHeight: Int): ValueAnimator {
    val anim = ValueAnimator.ofInt(currentHeight, endHeight)
    anim.addUpdateListener { valueAnimator ->
        val height = valueAnimator.animatedValue as Int
        val layoutParams = this.layoutParams
        layoutParams.height = height
        this.layoutParams = layoutParams
    }
    return anim
}

fun View.backgroundColorAnimator(@ColorInt endColor: Int): ObjectAnimator {
    if (this.background !is ColorDrawable) {
        throw IllegalStateException("View needs to have a background which is an instance of ColorDrawable")
    }
    return backgroundColorAnimator((this.background as ColorDrawable).color, endColor)
}

fun View.backgroundColorAnimator(@ColorInt startColor: Int, @ColorInt endColor: Int): ObjectAnimator {
    return ObjectAnimator.ofObject(this, "backgroundColor", argbEvaluator,
            startColor, endColor)
}

fun View.fadeOut(setAlphaToOne: Boolean = true, visibilityWhenComplete: Int = View.GONE): ViewPropertyAnimator {
    if (setAlphaToOne) {
        alpha = 1.0f
    }
    return animate()
            .alpha(0.0f)
            .withEndAction(VisibilityRunnable(this, visibilityWhenComplete))
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

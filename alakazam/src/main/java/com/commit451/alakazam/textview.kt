package com.commit451.alakazam

import android.animation.ObjectAnimator
import android.widget.TextView
import androidx.annotation.ColorInt

fun TextView.textColorAnimator(@ColorInt startColor: Int, @ColorInt endColor: Int): ObjectAnimator {
    return ObjectAnimator.ofObject(this, "textColor", Alakazam.argbEvaluator,
            startColor, endColor)
}

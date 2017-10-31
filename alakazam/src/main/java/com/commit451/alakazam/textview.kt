package com.commit451.alakazam

import android.animation.ObjectAnimator
import android.support.annotation.ColorInt
import android.widget.TextView

fun TextView.textColorAnimator(@ColorInt startColor: Int, @ColorInt endColor: Int): ObjectAnimator {
    return ObjectAnimator.ofObject(this, "textColor", Alakazam.argbEvaluator,
            startColor, endColor)
}

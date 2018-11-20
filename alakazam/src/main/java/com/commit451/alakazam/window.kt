package com.commit451.alakazam

import android.animation.ObjectAnimator
import android.annotation.TargetApi
import android.view.Window
import androidx.annotation.ColorInt

@TargetApi(21)
fun Window.statusBarColorAnimator(@ColorInt endColor: Int): ObjectAnimator {
    return statusBarColorAnimator(this.statusBarColor, endColor)
}

@TargetApi(21)
fun Window.statusBarColorAnimator(@ColorInt startColor: Int, @ColorInt endColor: Int): ObjectAnimator {
    return ObjectAnimator.ofObject(this, "statusBarColor", Alakazam.argbEvaluator,
            startColor, endColor)
}

@TargetApi(21)
fun Window.navigationBarColorAnimator(@ColorInt endColor: Int): ObjectAnimator {
    return navigationBarColorAnimator(navigationBarColor, endColor)
}

@TargetApi(21)
fun Window.navigationBarColorAnimator(@ColorInt startColor: Int, @ColorInt endColor: Int): ObjectAnimator {
    return ObjectAnimator.ofObject(this, "navigationBarColor", Alakazam.argbEvaluator,
            startColor, endColor)
}

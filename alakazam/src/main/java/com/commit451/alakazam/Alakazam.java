package com.commit451.alakazam;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.support.annotation.ColorInt;
import android.view.Window;

/**
 * Entry point into Animation things
 */
public class Alakazam {

    private static ArgbEvaluator sArgbEvaluator = new ArgbEvaluator();

    @TargetApi(21)
    public static ObjectAnimator statusBarColorAnimator(Window window, @ColorInt int endColor) {
        return statusBarColorAnimator(window, window.getStatusBarColor(), endColor);
    }

    @TargetApi(21)
    public static ObjectAnimator statusBarColorAnimator(Window window, @ColorInt int startColor, @ColorInt int endColor) {
        return ObjectAnimator.ofObject(window, "statusBarColor", sArgbEvaluator,
                startColor, endColor);
    }

    @TargetApi(21)
    public static ObjectAnimator navigationBarColorAnimator(Window window, @ColorInt int endColor) {
        return navigationBarColorAnimator(window, window.getNavigationBarColor(), endColor);
    }

    @TargetApi(21)
    public static ObjectAnimator navigationBarColorAnimator(Window window, @ColorInt int startColor, @ColorInt int endColor) {
        return ObjectAnimator.ofObject(window, "navigationBarColor", sArgbEvaluator,
                startColor, endColor);
    }
}

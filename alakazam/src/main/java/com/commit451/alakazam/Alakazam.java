package com.commit451.alakazam;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

/**
 * Entry point into Animation things
 */
public class Alakazam {

    private static ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    public static ValueAnimator widthAnimator(@NonNull final View view, int currentWidth, int endWidth) {
        ValueAnimator anim = ValueAnimator.ofInt(currentWidth, endWidth);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int width = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.width = width;
                view.setLayoutParams(layoutParams);
            }
        });
        return anim;
    }

    public static ValueAnimator heightAnimator(@NonNull final View view, int currentHeight, int endHeight) {
        ValueAnimator anim = ValueAnimator.ofInt(currentHeight, endHeight);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int height = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = height;
                view.setLayoutParams(layoutParams);
            }
        });
        return anim;
    }

    public static ObjectAnimator textColorAnimator(@NonNull TextView view, @ColorInt int startColor, @ColorInt int endColor) {
        return ObjectAnimator.ofObject(view, "textColor", argbEvaluator,
                startColor, endColor);
    }

    public static ObjectAnimator backgroundColorAnimator(@NonNull View view, @ColorInt int endColor) {
        if (!(view.getBackground() instanceof ColorDrawable)) {
            throw new IllegalStateException("View needs to have a background which is an instance of ColorDrawable");
        }
        return backgroundColorAnimator(view, ((ColorDrawable) view.getBackground()).getColor(), endColor);
    }

    public static ObjectAnimator backgroundColorAnimator(@NonNull View view, @ColorInt int startColor, @ColorInt int endColor) {
        return ObjectAnimator.ofObject(view, "backgroundColor", argbEvaluator,
                startColor, endColor);
    }

    @TargetApi(21)
    public static ObjectAnimator statusBarColorAnimator(@NonNull Window window, @ColorInt int endColor) {
        return statusBarColorAnimator(window, window.getStatusBarColor(), endColor);
    }

    @TargetApi(21)
    public static ObjectAnimator statusBarColorAnimator(@NonNull Window window, @ColorInt int startColor, @ColorInt int endColor) {
        return ObjectAnimator.ofObject(window, "statusBarColor", argbEvaluator,
                startColor, endColor);
    }

    @TargetApi(21)
    public static ObjectAnimator navigationBarColorAnimator(@NonNull Window window, @ColorInt int endColor) {
        return navigationBarColorAnimator(window, window.getNavigationBarColor(), endColor);
    }

    @TargetApi(21)
    public static ObjectAnimator navigationBarColorAnimator(@NonNull Window window, @ColorInt int startColor, @ColorInt int endColor) {
        return ObjectAnimator.ofObject(window, "navigationBarColor", argbEvaluator,
                startColor, endColor);
    }
}

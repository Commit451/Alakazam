package com.commit451.alakazam;

import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Shows the view and sets its alpha to 0. Usually used with {@link android.view.ViewPropertyAnimator#withStartAction(Runnable)}
 */
public class FadeInRunnable implements Runnable {

    private WeakReference<View> viewWeakReference;

    public FadeInRunnable(View view) {
        viewWeakReference = new WeakReference<>(view);
    }

    @Override
    public void run() {
        if (viewWeakReference != null) {
            View view = viewWeakReference.get();
            if (view != null) {
                view.setAlpha(0.0f);
                view.setVisibility(View.VISIBLE);
            }
        }
    }
}

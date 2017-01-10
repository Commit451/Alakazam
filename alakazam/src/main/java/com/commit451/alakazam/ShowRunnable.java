package com.commit451.alakazam;

import android.view.View;

import java.lang.ref.WeakReference;

/**
 * Shows the view. Usually used with {@link android.view.ViewPropertyAnimator#withStartAction(Runnable)}
 */
public class ShowRunnable implements Runnable {

    private WeakReference<View> viewWeakReference;

    public ShowRunnable(View view) {
        viewWeakReference = new WeakReference<>(view);
    }

    @Override
    public void run() {
        if (viewWeakReference != null) {
            View view = viewWeakReference.get();
            if (view != null) {
                view.setVisibility(View.VISIBLE);
            }
        }
    }
}

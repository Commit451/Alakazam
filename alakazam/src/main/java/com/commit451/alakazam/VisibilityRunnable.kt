package com.commit451.alakazam

import android.view.View

import java.lang.ref.WeakReference

/**
 * Changes the view visibility when run. Usually used with [android.view.ViewPropertyAnimator.withEndAction]
 */
class VisibilityRunnable(view: View, private val visibility: Int) : Runnable {

    private val viewWeakReference = WeakReference(view)

    override fun run() {
        val view = viewWeakReference.get()
        if (view != null) {
            view.visibility = visibility
        }
    }
}

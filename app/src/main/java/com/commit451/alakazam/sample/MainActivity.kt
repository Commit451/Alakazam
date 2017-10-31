package com.commit451.alakazam.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.commit451.alakazam.EaseInOutBezierInterpolator
import com.commit451.alakazam.fadeIn
import com.commit451.alakazam.fadeOut
import com.commit451.alakazam.widthAnimator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val icon = findViewById<ImageView>(R.id.icon)

        findViewById<View>(R.id.animate).setOnClickListener {
            if (icon.visibility == View.VISIBLE) {
                icon.fadeOut()
            } else {
                icon.fadeIn()
            }
        }

        val buttonAnimateMe = findViewById<Button>(R.id.animate_me)
        buttonAnimateMe.setOnClickListener {
            toggleText(buttonAnimateMe)
            val currentWidth = buttonAnimateMe.width
            buttonAnimateMe.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(buttonAnimateMe.height, View.MeasureSpec.UNSPECIFIED))
            val pendingWidth = buttonAnimateMe.measuredWidth
            val animator = buttonAnimateMe.widthAnimator(currentWidth, pendingWidth)
            animator.duration = 800
            animator.interpolator = EaseInOutBezierInterpolator()
            animator.start()
        }
        toggleText(buttonAnimateMe)
    }

    private fun toggleText(textView: TextView) {
        if (textView.text.toString() == "hi there hows it going today?") {
            textView.text = "hi"
        } else {
            textView.text = "hi there hows it going today?"
        }
    }
}

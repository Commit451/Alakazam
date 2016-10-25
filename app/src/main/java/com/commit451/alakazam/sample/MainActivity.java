package com.commit451.alakazam.sample;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.commit451.alakazam.Alakazam;
import com.commit451.alakazam.EaseInOutBezierInterpolator;
import com.commit451.alakazam.HideRunnable;
import com.commit451.alakazam.ShowRunnable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView icon = (ImageView) findViewById(R.id.icon);
        findViewById(R.id.animate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (icon.getVisibility() == View.VISIBLE) {
                    icon.animate().alpha(0.0f).withEndAction(new HideRunnable(icon));
                } else {
                    icon.animate().alpha(1.0f).withStartAction(new ShowRunnable(icon));
                }
            }
        });

        final Button buttonAnimateMe = (Button) findViewById(R.id.animate_me);
        buttonAnimateMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleText(buttonAnimateMe);
                int currentWidth = buttonAnimateMe.getWidth();
                buttonAnimateMe.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                        View.MeasureSpec.makeMeasureSpec(buttonAnimateMe.getHeight(), View.MeasureSpec.UNSPECIFIED));
                int pendingWidth = buttonAnimateMe.getMeasuredWidth();
                ValueAnimator animator = Alakazam.widthAnimator(buttonAnimateMe, currentWidth, pendingWidth);
                animator.setDuration(800);
                animator.setInterpolator(new EaseInOutBezierInterpolator());
                animator.start();
            }
        });
        toggleText(buttonAnimateMe);
    }

    private void toggleText(TextView textView) {
        if (textView.getText().toString().equals("hi there hows it going today?")) {
            textView.setText("hi");
        } else {
            textView.setText("hi there hows it going today?");
        }
    }
}

package com.commit451.alakazam.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

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
    }
}

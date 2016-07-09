package com.codekul.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       findViewById(R.id.btnRotate).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               animateView(R.anim.rotate);
           }
       });

        findViewById(R.id.btnCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateView(R.anim.custom);
            }
        });
    }

    private void animateView(int animation){

        //final ImageView image = (ImageView) findViewById(R.id.imageView);
        //image.startAnimation(AnimationUtils.loadAnimation(this,animation));

        findViewById(R.id.imageView)
                .startAnimation(AnimationUtils
                        .loadAnimation(this,animation));
    }
}

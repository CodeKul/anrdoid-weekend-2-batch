package com.melayer.intentandintentfilters;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class NextActivity extends AppCompatActivity {

    public static final String KEY_COLOR_MAIN = "mainColor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        changeColor();

        processBack();
    }

    private String getCurretColor(){

        String color = "none";
        Intent responsibleIntent =
                getIntent();

        Bundle bundle = responsibleIntent
                .getExtras();

        if(bundle != null) {
            color = bundle
                    .getString(MainActivity.KEY_NEXT_COLOR);
        }
        return color;
    }

    private void changeColor(){

        Intent responsibleIntent =
                getIntent();

        Bundle bundle = responsibleIntent
                .getExtras();

        if(bundle != null) {
            String color = bundle
                    .getString(MainActivity.KEY_NEXT_COLOR);

            if (color.equals("red")) {

                findViewById(R.id.relativeNext)
                        .setBackgroundColor(Color.RED);
            } else {
                findViewById(R.id.relativeNext)
                        .setBackgroundColor(Color.GREEN);
            }
        }
    }

    private void processBack(){

        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CheckBox checkBox =
                        (CheckBox) findViewById(R.id.checkChangeColor);

                Intent intent =
                        new Intent();

                Bundle bundle =
                        new Bundle();
                bundle.putString(KEY_COLOR_MAIN,checkBox.isChecked() ? getCurretColor() : "none");

                intent.putExtras(bundle);

                setResult(RESULT_OK,intent);

                finish();
            }
        });
    }
}

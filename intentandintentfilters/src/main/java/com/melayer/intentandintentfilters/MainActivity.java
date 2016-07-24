package com.melayer.intentandintentfilters;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               call();
            }
        });
    }

    private void check(){
        Intent intent =
                new Intent(); // default category
        intent.setAction("com.codekul.action.any");
        intent.setData(Uri.parse("http://codekul.com"));
        startActivity(intent);
    }

    private void dial(){

        Intent intent =
                new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        startActivity(intent);
    }

    private void call(){
        Intent intent =
                new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel://9762548833"));
        startActivity(intent);
    }
}

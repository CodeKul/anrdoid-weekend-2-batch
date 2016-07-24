package com.codekul.handlingruntimechangesbyown;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mt("onRestart");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation ==
                Configuration.ORIENTATION_LANDSCAPE){

            changeImage(R.drawable.my);
        }
        else if(newConfig.orientation ==
                Configuration.ORIENTATION_PORTRAIT) {

            changeImage(R.drawable.pin);
        }
        else {
            changeImage(R.mipmap.ic_launcher);
        }
        mt("onConfigurationCanged");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mt("onDestory");
    }

    private void changeImage(int id){

        final ImageView image = (ImageView) findViewById(R.id.imageState);
        image.setImageResource(id);
    }

    private void mt(String msg){

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

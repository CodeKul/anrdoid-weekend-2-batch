package com.melayer.assetsandresources;

import android.content.res.AssetManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readAssets();

        int pureWhite = R.color.pureWhite; // this is id

        pureWhite = getResources()
                .getColor(R.color.pureWhite);

        pureWhite = ContextCompat
                .getColor(this,R.color.pureWhite);

        String []cities = getResources()
                .getStringArray(R.array.cities);
    }

    private void readAssets(){
        AssetManager manager =
                getAssets();
        try {
            InputStream is =
                    manager.open("uuu.txt");

            StringBuilder builder =
                    new StringBuilder();

            //String str = "";
            while(true){

                int ch = is.read();
                if(ch == -1) break; // EOF
                //else str += (char)ch;
                else builder.append((char)ch);
            }
            Log.i("@codekul",builder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

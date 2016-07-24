package com.melayer.filemanipulation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeToInternalStorage();

        readInternalStorage();

        fewUtilityMethods();
    }

    // /data/data/your-package/files/
    private void writeToInternalStorage(){

        try {

            FileOutputStream fos =
                    openFileOutput("my.txt",MODE_PRIVATE);
            fos.write("Hello to codekul.com".getBytes());
            fos.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readInternalStorage(){

        try {

            FileInputStream fis =
                    openFileInput("my.txt");

            StringBuilder builder =
                    new StringBuilder();

            while(true){
                int ch = fis.read();
                if(ch == -1) break; //EOF
                else builder.append((char)ch);
            }

            Log.i("@codekul",builder.toString());

            fis.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void fewUtilityMethods(){

        File filesDir = getFilesDir();
        Log.i("@codekul","getFilesDir - "+filesDir.getPath());

        File dir = getDir("my",MODE_PRIVATE);
        Log.i("@codekul","getDir - "+dir.getPath());

        String []files = fileList();

        for(String file : files){
            Log.i("@codekul",file);
        }
    }
}

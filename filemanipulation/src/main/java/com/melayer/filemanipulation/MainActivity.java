package com.melayer.filemanipulation;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        appsPrivateDataOnExternal();

        readAppsPrivateData();

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

    private Boolean isWorking(){

        return  Environment
                .getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED);
    }

    private void writeToExternalStorage(){

        if(isWorking()) {
            File file =
                    new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "uuu.txt");
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write("Hellow to external storage".getBytes());
                fos.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }else {
            Log.i("@codekul","Media Not mounted");
        }
    }

    private void readFromExternalStorage() {

        File parent = Environment.getExternalStoragePublicDirectory("my");
        parent.mkdir();

        File file =
                new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "uuu.txt");

        if (isWorking()) {
            try {
                FileInputStream fis =
                        new FileInputStream(file);

                StringBuilder builder =
                        new StringBuilder();

                while (true) {
                    int ch = fis.read();
                    if (ch == -1) break;
                    else builder.append((char) ch);
                }

                Log.i("@codekul", builder.toString());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Log.i("@codekul", "Media Not mounted");
        }
    }

    private void appsPrivateDataOnExternal(){

        File file =
                new File(getExternalFilesDir(null),"uuu.txt");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write("Apps private data".getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readAppsPrivateData(){

        File file =
                new File(getExternalFilesDir(null),"uuu.txt");

            try {
                FileInputStream fis =
                        new FileInputStream(file);

                StringBuilder builder =
                        new StringBuilder();

                while (true) {
                    int ch = fis.read();
                    if (ch == -1) break;
                    else builder.append((char) ch);
                }

                Log.i("@codekul", builder.toString());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}

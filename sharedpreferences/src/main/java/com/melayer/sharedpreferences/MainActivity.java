package com.melayer.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_INT = "int";
    public static final String KEY_FLOAT = "float";
    public static final String KEY_BOOLEAN = "bool";
    public static final String KEY_STRING = "str";

    // /data/data/your-package-name/shared_prefs/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveToPrefrenceFile();

        readData();
    }

    private void saveToPrefrenceFile(){

//        SharedPreferences prefs =
//                getPreferences(MODE_PRIVATE);

        SharedPreferences prefs =
                getSharedPreferences("my_prefs",MODE_PRIVATE);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_INT,10);
        editor.putString(KEY_STRING,"{code}kul;");
        editor.putFloat(KEY_FLOAT,4.5f);
        editor.putBoolean(KEY_BOOLEAN,true);

        editor.commit();
    }

    private void readData(){

        SharedPreferences prefs =
                getSharedPreferences("my_prefs",MODE_PRIVATE);

        String str =
                prefs.getString(KEY_STRING,"default");
        Integer _int = prefs.getInt(KEY_INT,-1);
        Boolean _boolean = prefs.getBoolean(KEY_BOOLEAN,true);
        Float _float = prefs.getFloat(KEY_FLOAT,2f);

        Log.i("@codekul","String - "+str);
        Log.i("@codekul","Int - "+ _int);
        Log.i("@codekul","Boolean - "+ _boolean);
        Log.i("@codekul","Float - "+ _float);
    }
}

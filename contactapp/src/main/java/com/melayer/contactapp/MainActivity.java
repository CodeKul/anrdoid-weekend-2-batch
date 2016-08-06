package com.melayer.contactapp;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentResolver resolver =
                this.getContentResolver();

        //Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Uri uri = Uri.parse("content://com.codekul.provider");

        //String[] projection = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
          //      ContactsContract.CommonDataKinds.Phone.NUMBER};
        String []projection = {"userName","rollNo"};
        String selection = null;
        String[] selectionArgs = null;
        String sortOrder = null;

        Cursor cursor =
                resolver.query(uri,projection,selection,selectionArgs,sortOrder);

        ArrayList<String> dataSet =
                new ArrayList<>();

        while(cursor.moveToNext()){

            String name =
                    //cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    cursor.getString(cursor.getColumnIndex("userName"));
//            String number =
//                    cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            Integer number =
                    cursor.getInt(cursor.getColumnIndex("rollNo"));

            dataSet.add(name + "\n"+number);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        dataSet);
        ((ListView)findViewById(R.id.listContacts)).setAdapter(adapter);
    }
}

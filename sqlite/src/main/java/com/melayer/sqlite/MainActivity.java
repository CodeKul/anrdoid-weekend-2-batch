package com.melayer.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final DbHelper helper =
                new DbHelper(this,"my.sqdb",null,1);

        findViewById(R.id.btnInsert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase sqDb =
                        helper.getWritableDatabase();

                String table = "myUser";
                //String nullColumnHack = "rollNo";
                String nullColumnHack = null;
                ContentValues values = new ContentValues();
                values.put("userName",getUserName());
                values.put("rollNo",getRollNo());

                sqDb.insert(table,nullColumnHack,values);

                sqDb.close();
            }
        });

        findViewById(R.id.btnQuery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase sqDb = helper.getReadableDatabase();

                String table = "myUser";
                String[] columns = {"userName"};
                //String[] columns = null;
                String selection = "rollNo = ?";
                //String selection = null;
                String[] selectionArgs = {getRollNo()};
                //String[] selectionArgs = null;
                String groupBy = null;
                String having = null;
                String orderBy = null;

                Cursor cursor = sqDb.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);

                while(cursor.moveToNext()){

                    String userName = cursor.getString(0);
                    //int rollNo = cursor.getInt(cursor.getColumnIndex("rollNo"));

                    Log.i("@codekul","User Name - "+userName);
                    //Log.i("@codekul","Roll # - "+rollNo);
                }

                sqDb.close();
            }
        });

        findViewById(R.id.btnUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase sqDb = helper.getWritableDatabase();

                String table=  "myUser";
                ContentValues values = new ContentValues();
                values.put("userName",getUserName());
                String whereClause = " rollNo = ?";
                String[] whereArgs = {getRollNo()};

                sqDb.update(table,values,whereClause,whereArgs);

                sqDb.close();
            }
        });

        findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SQLiteDatabase sqDb = helper.getWritableDatabase();
                String table = "myUser";
                String whereClause = "rollNo = ?";
                String []whereArgs = {getRollNo()};

                sqDb.delete(table,whereClause,whereArgs);

                sqDb.close();
            }
        });
    }



    private String getUserName(){
        return ((EditText)findViewById(R.id.edtUserName))
                .getText()
                .toString();
    }

    private String getRollNo(){
        return ((EditText)findViewById(R.id.edtRollNo))
                .getText()
                .toString();
    }
}

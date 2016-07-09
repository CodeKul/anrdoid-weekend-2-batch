package com.codekul.adapterviews;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        useCustomAdapter();
    }

    private void useCustomAdapter(){

        ArrayList<MyItem> dataSet =
                new ArrayList<>();

        MyItem item1 = new MyItem();
        item1.setImageId(R.mipmap.ic_launcher);
        item1.setTextName("India");
        dataSet.add(item1);

        MyItem item2 = new MyItem();
        item2.setImageId(R.mipmap.ic_launcher);
        item2.setTextName("China");
        dataSet.add(item2);

        MyItem item3 = new MyItem();
        item3.setImageId(R.drawable.my);
        item3.setTextName("Japan");
        dataSet.add(item3);

        MyItem item4 = new MyItem();
        item4.setImageId(R.mipmap.ic_launcher);
        item4.setTextName("Nepal");
        dataSet.add(item4);

        MyAdapter adapter =
                new MyAdapter(this,dataSet);

        final ListView listCountries =
                (ListView) findViewById(R.id.listCountries);
        listCountries.setAdapter(adapter);

    }

    private void useArrayAdapter(){

        ArrayList<String>
                dataSet = new ArrayList<>();
        dataSet.add("India");
        dataSet.add("Chiana");
        dataSet.add("Japan");
        dataSet.add("Shri Lanka");
        dataSet.add("Nepal");

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        dataSet);

        final ListView listCountries =
                (ListView) findViewById(R.id.listCountries);
        listCountries.setAdapter(adapter);
    }
}

package com.codekul.adapterviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aniruddha on 3/7/16.
 */
public class MyAdapter  extends BaseAdapter{

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<MyItem> dataSet;

    public MyAdapter(Context context, ArrayList<MyItem> dataSet){

        this.context = context;
        this.dataSet = dataSet;

        inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dataSet.get(position).getItemId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View view = inflater.inflate(R.layout.custom_item,
                null,
                false);

        ImageView image =
                (ImageView) view.findViewById(R.id.imageItem);
        image.setImageResource(dataSet
                .get(position)
                .getImageId());

        TextView text =
                (TextView) view.findViewById(R.id.textName);
        text.setText(dataSet
                .get(position)
                .getTextName());

        return view;
    }
}

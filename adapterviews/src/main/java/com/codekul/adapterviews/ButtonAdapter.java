package com.codekul.adapterviews;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;

/**
 * Created by aniruddha on 9/7/16.
 */
public class ButtonAdapter extends BaseAdapter{

    private Context context;

    public ButtonAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Button btn = new Button(context);
        btn.setLayoutParams(
                new AbsListView
                        .LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,
                        AbsListView.LayoutParams.WRAP_CONTENT));

        btn.setText(""+position);

        return btn;
    }
}

package com.codekul.adapterviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        final GridView gridButtons =
                (GridView) findViewById(R.id.gridButtons);

        final ButtonAdapter adapter =
                new ButtonAdapter(this);
        gridButtons.setAdapter(adapter);
    }
}

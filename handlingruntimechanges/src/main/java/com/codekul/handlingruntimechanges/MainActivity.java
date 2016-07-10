package com.codekul.handlingruntimechanges;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if(savedInstanceState != null){

            final TextView textView =
                    (TextView) findViewById(R.id.textView);
            String myData = savedInstanceState.getString("key_my_data");
            textView.setText(myData);
        }*/

        findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextView textView =
                        (TextView) findViewById(R.id.textView);
                textView.setText(""+new Date());
            }
        });

        mt("onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mt("onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        final TextView textView =
                (TextView) findViewById(R.id.textView);

        outState.putString("key_my_data",textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null){

            final TextView textView =
                    (TextView) findViewById(R.id.textView);
            String myData = savedInstanceState.getString("key_my_data");
            textView.setText(myData);
        }
    }

    private void mt(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}

package com.codekul.dialognotifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAlert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(MyDialogFragment.TAG_ALERT);
            }
        });

        findViewById(R.id.btnDatePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(MyDialogFragment.TAG_DATE_PICKER);
            }
        });

        findViewById(R.id.btnTimePicker).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(MyDialogFragment.TAG_TIME_PICKER);
            }
        });

        findViewById(R.id.btnProgress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(MyDialogFragment.TAG_PROGRESS_DIALOG);
            }
        });

        findViewById(R.id.btnCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(MyDialogFragment.TAG_CUSTOM);
            }
        });
    }

    private void showDialog(String tag){
        MyDialogFragment dialog =
                new MyDialogFragment();
        dialog.show(getSupportFragmentManager(),tag);
    }
}

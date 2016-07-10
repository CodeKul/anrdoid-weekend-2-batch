package com.codekul.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void runFragmentTxn(int whichContainer, Fragment whichFragment){

        FragmentManager manager =
                getSupportFragmentManager();
        FragmentTransaction txn = manager.beginTransaction();
        //txn.add(whichContainer,whichFragment);
        txn.replace(whichContainer,whichFragment);
        txn.commit();
    }
}

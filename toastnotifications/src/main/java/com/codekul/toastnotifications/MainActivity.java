package com.codekul.toastnotifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnToast)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast toast = Toast.makeText(MainActivity.this,
                                "This is toast",
                                Toast.LENGTH_SHORT);
                        toast.setView(new Button(MainActivity.this));
                        toast.show();

                    }
                });
    }
}

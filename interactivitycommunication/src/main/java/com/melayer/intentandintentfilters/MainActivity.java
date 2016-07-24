package com.melayer.intentandintentfilters;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_NEXT_COLOR = "color";
    public static final int REQ_NEXT = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btnNext)
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent =
                        new Intent(MainActivity.this,
                                NextActivity.class);

                RadioButton rb =
                        (RadioButton) findViewById(R.id.radioRed);

                Bundle bundle = new Bundle();

                //bundle.putInt("key_any",1);
                bundle.putString(KEY_NEXT_COLOR,rb.isChecked() ? "red" : "green");

                intent.putExtras(bundle);

                //startActivity(intent);

                startActivityForResult(intent,REQ_NEXT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_NEXT){
            if(resultCode == RESULT_OK){

                if(data != null) {

                    Bundle bundle = data.getExtras();
                    String color = bundle
                            .getString(NextActivity.KEY_COLOR_MAIN);

                    if(!color.equals("none")){

                        if(color.equals("red")){

                            findViewById(R.id.linearMain).setBackgroundColor(Color.RED);
                        }
                        else {
                            findViewById(R.id.linearMain).setBackgroundColor(Color.GREEN);
                        }
                    }
                }
            }
        }
    }
}

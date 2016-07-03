package com.codekul.weekendbatch_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //px = dp * (dpi / 160)

        //getWindow().setBackgroundDrawableResource(R.drawable.my);
        setContentView(R.layout.activity_main);

        Click clickMy = new Click();

        Button btnOkay =
                (Button) findViewById(R.id.btnOkay);
        btnOkay.setOnClickListener(clickMy);

        Button btnDone =
                (Button) findViewById(R.id.btnDone);
        btnDone.setOnClickListener(clickMy);

        Button btnSample =
                (Button) findViewById(R.id.btnSample);

    }

    private void createUibyCode(){

        // Every view needs context and layout parameters
        //View view = new View(this/*I was expecting object context and you passed object of Activity*/);

        LinearLayout layoutRoot =
                new LinearLayout(this);
        LinearLayout.LayoutParams paramsRoot =
                new LinearLayout.LayoutParams(300,300);
        layoutRoot.setLayoutParams(paramsRoot);
        layoutRoot.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams paramsEdtName =
                new LinearLayout.LayoutParams(300,150);
        EditText edtName = new EditText(this);
        edtName.setLayoutParams(paramsEdtName);
        layoutRoot.addView(edtName);

        LinearLayout.LayoutParams paramsBtnOkay =
                new LinearLayout.LayoutParams(300,150);
        Button btnOkay =
                new Button(this);
        btnOkay.setLayoutParams(paramsBtnOkay);
        layoutRoot.addView(btnOkay);

        setContentView(layoutRoot);
    }

    private class Click implements  View.OnClickListener{

        @Override
        public void onClick(View v) {

            TextView textStatus =
                    (TextView) findViewById(R.id.textStatus);

            EditText edtName = // obj created by setContentView
                    (EditText) findViewById(R.id.edtName);

            if(v.getId() == R.id.btnOkay){

                String name = edtName
                        .getText()
                        .toString();

                textStatus.setText(name.toUpperCase());
            }
            else {

                String name = edtName
                        .getText()
                        .toString();

                textStatus.setText(name.toLowerCase());
            }
        }
    }
}

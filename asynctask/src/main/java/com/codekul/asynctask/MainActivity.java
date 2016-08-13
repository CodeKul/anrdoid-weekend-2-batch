package com.codekul.asynctask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnOkay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MyTask().execute(1,50,1000);
            }
        });
    }

    private void workerThread(){

        final TextView text = (TextView)findViewById(R.id.textInfo);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 20 ; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    text.setText("" + i); // kill your app
                }
            }
        }).start();
    }

    private class MyTask extends AsyncTask<Integer/*params*/,Integer/*progress*/,Boolean/*result*/>{

        private ProgressDialog pd;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pd = ProgressDialog.show(MainActivity.this,"title","message");
            //ui thread
        }

        @Override
        protected Boolean/*result*/ doInBackground(Integer... params/*params*/) {

            // worker thread

            for(int i = params[0] ;i < params[1] ; i++)
            {
                try {
                    Thread.sleep(params[2]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i/*progress*/);
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean/*result*/) {
            // ui thread
            super.onPostExecute(aBoolean);

            pd.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values/*progress*/) {
            super.onProgressUpdate(values);

            ((TextView)findViewById(R.id.textInfo)).setText(""+values[0]);

            // ui theread
        }
    }
}

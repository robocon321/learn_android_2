package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.learnandroid2.R;

public class AsyncTaskBasicActivity extends AppCompatActivity {
    TextView txtAsyncTaskBasic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_basic);
        txtAsyncTaskBasic = findViewById(R.id.txtAsyncTaskBasic);
        txtAsyncTaskBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ThongTin().execute();
            }
        });
    }

    private class ThongTin extends AsyncTask<Void, String, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtAsyncTaskBasic.setText("Start \n");
        }

        @Override
        protected String doInBackground(Void... voids) {
            for(int i=0;i<5;i++){
                try {
                    Thread.sleep(1000);
                    publishProgress(i+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "End";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtAsyncTaskBasic.setText(txtAsyncTaskBasic.getText()+values[0]+"\n");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtAsyncTaskBasic.setText(txtAsyncTaskBasic.getText()+s);
        }
    }
}
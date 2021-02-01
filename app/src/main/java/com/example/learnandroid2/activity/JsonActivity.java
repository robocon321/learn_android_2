package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.learnandroid2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class JsonActivity extends AppCompatActivity {
    Button btnReadJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        btnReadJson = findViewById(R.id.btnReadJson);
        btnReadJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ReadJsonObj().execute("https://api.mocki.io/v1/e1ce6c11");
            }
        });
    }

    private class ReadJsonObj extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream in = url.openConnection().getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String result = "";
                String str = "";
                while((str = reader.readLine()) != null){
                    result += str;
                }

                JSONArray arrRoot = new JSONArray(result);
                JSONObject item = arrRoot.getJSONObject(0);
                String data = item.getString("picture");

                return data;
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(JsonActivity.this, s+"", Toast.LENGTH_SHORT).show();
        }
    }
}
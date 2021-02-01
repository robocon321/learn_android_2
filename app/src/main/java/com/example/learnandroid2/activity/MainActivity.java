package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.learnandroid2.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    Button btnSharedPre, btnAnimation, btnAsyncTaskBasic, btnAsyncLoadImage;
    Button btnReadRss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        setEvents();
    }

    public void addControls(){
        btnSharedPre = findViewById(R.id.btnSharedPre);
        btnAnimation = findViewById(R.id.btnAnimation);
        btnAsyncTaskBasic = findViewById(R.id.btnAsyncTaskBasic);
        btnAsyncLoadImage = findViewById(R.id.btnAsyncLoadImage);
        btnReadRss = findViewById(R.id.btnReadRSS);
    }

    public void setEvents(){
        btnSharedPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SharedPreActivity.class);
                startActivity(intent);
            }
        });

        btnAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
                startActivity(intent);
            }
        });

        btnAsyncTaskBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AsyncTaskBasicActivity.class);
                startActivity(intent);
            }
        });

        btnAsyncLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AsyncTaskLoadImageActivity.class);
                startActivity(intent);
            }
        });

        btnReadRss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ReadRSS().execute("https://vnexpress.net/rss/tin-moi-nhat.rss");
            }
        });
    }

    private class ReadRSS extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                InputStream in = url.openConnection().getInputStream();

                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document document = builder.parse(in);
                Element element = document.getDocumentElement();
                Node node = element.getElementsByTagName("image").item(0);
                return node.getTextContent();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(MainActivity.this, s+"", Toast.LENGTH_SHORT).show();
        }
    }
}
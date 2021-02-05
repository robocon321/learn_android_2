package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.learnandroid2.R;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {
    Button btnSharedPre, btnAnimation, btnAsyncTaskBasic, btnAsyncLoadImage;
    Button btnReadRss, btnJson, btnVolleyString, btnVolleyJson, btnMedia;
    Button btnTodo, btnFragment, btnFragment_AddRemove, btnSocketIO;
    Button btnService;

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
        btnJson = findViewById(R.id.btnJson);
        btnVolleyString = findViewById(R.id.btnVolleyString);
        btnVolleyJson = findViewById(R.id.btnVolleyJson);
        btnMedia = findViewById(R.id.btnMedia);
        btnTodo = findViewById(R.id.btnTodo);
        btnFragment = findViewById(R.id.btnFragment);
        btnFragment_AddRemove = findViewById(R.id.btnFragment_AddRemove);
        btnSocketIO = findViewById(R.id.btnSocketIO);
        btnService = findViewById(R.id.btnService);
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

        btnJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, JsonActivity.class);
                startActivity(intent);
            }
        });

        btnVolleyString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://developer.mozilla.org/vi/docs/Learn/Getting_started_with_the_web/HTML_basics";

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Response", response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.getMessage());
                    }
                });
                queue.add(request);
            }
        });
        btnVolleyJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://api.mocki.io/v1/e1ce6c11";
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("Response", response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Error", error.getMessage());
                    }
                });
                queue.add(request);
            }
        });
        btnMedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MediaActivity.class);
                startActivity(intent);
            }
        });
        btnTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SqliteTodoActivity.class);
                startActivity(intent);
            }
        });
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentActivity.class);
                startActivity(intent);
            }
        });

        btnFragment_AddRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RemoveAddFragmentActivity.class);
                startActivity(intent);
            }
        });

        btnSocketIO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SocketIoActivity.class);
                startActivity(intent);
            }
        });

        btnService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServiceActivity.class);
                startActivity(intent);
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
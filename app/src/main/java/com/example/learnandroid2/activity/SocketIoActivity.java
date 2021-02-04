package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.learnandroid2.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class SocketIoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_io);
        Socket socket = null;
        try {
            socket = IO.socket("http://192.168.1.8:3000/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        socket.connect();
        socket.emit("data_client", "Hello world");
        socket.on("data_server", onReceiveData);
    }

    private Emitter.Listener onReceiveData =  new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JSONObject obj = (JSONObject) args[0];
                        try {
                            Toast.makeText(SocketIoActivity.this, obj.getString("noidung").toString()+"", Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
}
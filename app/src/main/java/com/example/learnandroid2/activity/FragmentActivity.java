package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.learnandroid2.R;
import com.example.learnandroid2.utils.FragmentA;

public class FragmentActivity extends AppCompatActivity {
    TextView txtMain;
    EditText editMain;
    Button btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        txtMain = findViewById(R.id.txtMain);
        editMain = findViewById(R.id.editMain);
        btnMain = findViewById(R.id.btnMain);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentA fragA = (FragmentA) getFragmentManager().findFragmentById(R.id.fragmentA);
                fragA.txtFragmentA.setText(editMain.getText());
            }
        });
    }
}
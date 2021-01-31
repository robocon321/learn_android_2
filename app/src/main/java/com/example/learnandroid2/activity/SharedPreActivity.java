package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learnandroid2.R;

public class SharedPreActivity extends AppCompatActivity {
    EditText editUname, editPwd;
    CheckBox ckSaveAccount;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pre);
        sharedPreferences = getSharedPreferences("data_account", MODE_PRIVATE);
        addControls();
    }

    public void addControls(){
        editUname = findViewById(R.id.editUname);
        editPwd = findViewById(R.id.editPwd);
        ckSaveAccount = findViewById(R.id.ckSaveAccount);
        boolean isChecked = sharedPreferences.getBoolean("isChecked", false);
        if(isChecked){
            String uname = sharedPreferences.getString("uname", "");
            String pwd = sharedPreferences.getString("pwd", "");

            editUname.setText(uname);
            editPwd.setText(pwd);
        }

        ckSaveAccount.setChecked(isChecked);
    }

    @Override
    protected void onStop() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isChecked", ckSaveAccount.isChecked());
        editor.putString("uname", editUname.getText().toString());
        editor.putString("pwd", editPwd.getText().toString());
        editor.commit();
        Toast.makeText(this, "Hello world", Toast.LENGTH_SHORT).show();
        super.onStop();
    }
}
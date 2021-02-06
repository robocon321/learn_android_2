package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.example.learnandroid2.R;
import com.example.learnandroid2.adapter.MyContextAdapter;
import com.example.learnandroid2.utils.MyContext;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ViewPager viewPager = findViewById(R.id.viewPager);

        ArrayList<MyContext> list = new ArrayList<>();
        list.add(new MyContext("#E64A19", R.drawable.close, "Close Icon"));
        list.add(new MyContext("#80CBC4", R.drawable.download, "Download Icon"));
        list.add(new MyContext("#82B1FF", R.drawable.delete, "Delete Icon"));
        list.add(new MyContext("#F8BBD0", R.drawable.computer, "Computer Icon"));

        MyContextAdapter adapter = new MyContextAdapter(list, R.layout.layout_view_pager, this);
        viewPager.setAdapter(adapter);
    }
}
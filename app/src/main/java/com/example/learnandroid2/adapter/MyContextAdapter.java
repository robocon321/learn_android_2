package com.example.learnandroid2.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.learnandroid2.R;
import com.example.learnandroid2.utils.MyContext;

import java.util.ArrayList;

public class MyContextAdapter extends PagerAdapter {
    private ArrayList<MyContext> list;
    private int resource;
    private Context context;

    public MyContextAdapter(ArrayList<MyContext> list, int resource, Context context) {
        this.list = list;
        this.resource = resource;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource, container, false);

        LinearLayout linearLayout = view.findViewById(R.id.layout);
        ImageView imgView = view.findViewById(R.id.imgViewPager);
        TextView txtView = view.findViewById(R.id.txtViewPager);

        MyContext myContext = list.get(position);

        linearLayout.setBackgroundColor(Color.parseColor(myContext.getColor()));
        imgView.setImageResource(myContext.getIcon());
        txtView.setText(myContext.getDescription());

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

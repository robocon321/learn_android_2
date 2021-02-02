package com.example.learnandroid2.utils;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.learnandroid2.R;

public class FragmentC extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_c, null);
//        View view = inflater.inflate(R.layout.layout_fragment_c, container);
//         Dung cho bai Fragment event
        return view;
    }
}

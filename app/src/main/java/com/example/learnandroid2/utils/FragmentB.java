package com.example.learnandroid2.utils;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.learnandroid2.R;

public class FragmentB extends Fragment {
    Button btnFragmentB;
    TextView txtFragmentB;
    EditText editFragmentB;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_b, container);

        btnFragmentB = view.findViewById(R.id.btnFragmentB);
        txtFragmentB = view.findViewById(R.id.txtFragmentB);
        editFragmentB = view.findViewById(R.id.editFragmentB);

        btnFragmentB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtFragmentA = getActivity().findViewById(R.id.fragmentA).findViewById(R.id.txtFragmentA);
                txtFragmentA.setText(editFragmentB.getText());
            }
        });

        return view;
    }
}

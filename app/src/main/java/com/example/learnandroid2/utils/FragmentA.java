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

public class FragmentA extends Fragment {
    public Button btnFragmentA;
    public TextView txtFragmentA;
    public EditText editFragmentA;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragment_a, null);
//        View view = inflater.inflate(R.layout.layout_fragment_a, container);
//         Dung cho bai Fragment event

        btnFragmentA = view.findViewById(R.id.btnFragmentA);
        txtFragmentA = view.findViewById(R.id.txtFragmentA);
        editFragmentA = view.findViewById(R.id.editFragmentA);

        btnFragmentA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtMain = getActivity().findViewById(R.id.txtMain);
                txtMain.setText(editFragmentA.getText());
            }
        });
        return view;
    }
}

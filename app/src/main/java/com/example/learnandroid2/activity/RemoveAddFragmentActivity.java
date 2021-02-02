package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnandroid2.R;
import com.example.learnandroid2.utils.FragmentA;
import com.example.learnandroid2.utils.FragmentB;
import com.example.learnandroid2.utils.FragmentC;

public class RemoveAddFragmentActivity extends AppCompatActivity {
    Button btnAddA, btnAddB, btnAddC, btnRemoveA, btnRemoveB, btnRemoveC, btnBack, btnPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_add_fragment);
        addControls();
    }

    public void addControls(){
        btnAddA = findViewById(R.id.btnAddA);
        btnAddB = findViewById(R.id.btnAddB);
        btnAddC = findViewById(R.id.btnAddC);
        btnRemoveA = findViewById(R.id.btnRemoveA);
        btnRemoveB = findViewById(R.id.btnRemoveB);
        btnRemoveC = findViewById(R.id.btnRemoveC);
        btnBack = findViewById(R.id.btnBack);
        btnPop = findViewById(R.id.btnPop);
    }

    public void addFragmentA(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.frame, new FragmentA(), "A");
        transaction.addToBackStack("a");
        transaction.commit();
    }

    public void addFragmentB(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.frame, new FragmentB(), "B");
        transaction.addToBackStack("b");
        transaction.commit();
    }

    public void addFragmentC(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.frame, new FragmentC(), "C");
        transaction.addToBackStack("c");
        transaction.commit();
    }

    public void removeFragmentA(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        FragmentA fragA = (FragmentA) getFragmentManager().findFragmentByTag("A");
        if(fragA != null){
            transaction.remove(fragA);
            transaction.commit();
        }
    }
    public void removeFragmentB(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        FragmentB fragB = (FragmentB) getFragmentManager().findFragmentByTag("B");
        if(fragB != null){
            transaction.remove(fragB);
            transaction.commit();
        }
    }
    public void removeFragmentC(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        FragmentC fragC = (FragmentC) getFragmentManager().findFragmentByTag("C");
        if(fragC != null){
            transaction.remove(fragC);
            transaction.commit();
        }
    }

    public void back(View view){
        getFragmentManager().popBackStack();
    }

    public void popA(View view){
        getFragmentManager().popBackStack("a", 0);
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
        else
            super.onBackPressed();
    }
}
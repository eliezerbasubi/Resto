package com.example.eliezer.resto;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.os.Bundle;

public class GeneralActivity extends AppCompatActivity {

    SessionPager sessionPager;
    ViewPager viewPager;
    TabLayout tabLayout;
    private Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.mainTab);

        viewPager.setAdapter(new SessionPager(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

    }
}

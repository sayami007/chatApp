package com.a3callistos.chatapplication.app;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.a3callistos.chatapplication.R;
import com.a3callistos.chatapplication.adapter.CustomViewPagerAdapter;

import butterknife.ButterKnife;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager vpMain;
    CircleIndicator circleIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);
        ButterKnife.inject(this);

        vpMain = (ViewPager) findViewById(R.id.vp_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        vpMain.setAdapter(new CustomViewPagerAdapter(fragmentManager));
        circleIndicator = (CircleIndicator) findViewById(R.id.circleIndicator);
        circleIndicator.setViewPager(vpMain);
    }

    @OnClick(R.id.btn_continue)
    void continueToMainPage() {
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }
}

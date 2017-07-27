package com.a3callistos.chatapplication.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.a3callistos.chatapplication.R;
import com.a3callistos.chatapplication.fragment.ChatGlobal;
import com.a3callistos.chatapplication.fragment.ChatLocal;

import static com.a3callistos.chatapplication.R.id.mainFrameLayout;
import static com.a3callistos.chatapplication.R.id.menu_chat_global;
import static com.a3callistos.chatapplication.R.id.menu_chat_local;

/**
 * Created by Bibesh on 7/27/17.
 */

public class MainPage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar tbMain;
    NavigationView designNavigationView;
    DrawerLayout drawerLayout;
    FrameLayout mainFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbMain = (Toolbar) findViewById(R.id.tb_main);
        setSupportActionBar(tbMain);
        tbMain.setTitle(getResources().getString(R.string.app_name));

        mainFrameLayout = (FrameLayout) findViewById(R.id.mainFrameLayout);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        designNavigationView = (NavigationView) findViewById(R.id.design_navigation_view);
        designNavigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, tbMain, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        showNavigationView();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager manager = null;
        FragmentTransaction transaction = null;

        switch (item.getItemId()) {
            case menu_chat_global:
                Log.v("GLOVAL", "GLOBAL");
                manager = getSupportFragmentManager();
                ChatGlobal global = new ChatGlobal();
                transaction = manager.beginTransaction();
                transaction.add(R.id.mainFrameLayout, global);
                transaction.commit();
                hideNavigationView();
                break;
            case menu_chat_local:
                ChatLocal local = new ChatLocal();
                manager = getSupportFragmentManager();
                transaction = manager.beginTransaction();
                transaction.replace(R.id.mainFrameLayout, local);
                transaction.commit();
                hideNavigationView();
                break;
        }
        return true;

    }

    private void hideNavigationView() {
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    private void showNavigationView() {
        drawerLayout.openDrawer(GravityCompat.START);
    }
}

package com.a3callistos.chatapplication.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;

import com.a3callistos.chatapplication.R;
import com.a3callistos.chatapplication.fragment.WalkthroughFragment;

/**
 * Created by Bibesh on 7/27/17.
 */

public class CustomViewPagerAdapter extends FragmentPagerAdapter {

    public CustomViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        WalkthroughFragment fragment = null;
        if (position == 0) {
            fragment = new WalkthroughFragment(R.layout.card_layout_1);
            return fragment;
        } else if (position == 1) {
            fragment = new WalkthroughFragment(R.layout.card_layout_2);
            return fragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}

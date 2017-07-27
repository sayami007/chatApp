package com.a3callistos.chatapplication.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.a3callistos.chatapplication.R;

/**
 * Created by Bibesh on 7/27/17.
 */

public class WalkthroughFragment extends Fragment {

    int layout;

    @SuppressLint("ValidFragment")
    public WalkthroughFragment(int card_layout_1) {
        this.layout = card_layout_1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(layout, container, false);
        return v;
    }
}

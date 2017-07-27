package com.a3callistos.chatapplication.fragment;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.a3callistos.chatapplication.R;

import com.a3callistos.chatapplication.model.*;
import com.squareup.picasso.Picasso;
import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.commons.models.IMessage;
import com.stfalcon.chatkit.commons.models.MessageContentType;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Bibesh on 7/27/17.
 */

public class ChatGlobal extends Fragment implements MessageInput.InputListener, MessagesListAdapter.OnMessageClickListener, MessagesListAdapter.OnMessageViewClickListener {
    MessagesList customMessageList;
    MessageInput customMessageInput;
    MessagesListAdapter<CustomMessage> adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_layout, container, false);
        customMessageInput = view.findViewById(R.id.customMessageInput);
        customMessageInput.setInputListener(this);

        customMessageList = view.findViewById(R.id.customMessageList);

        Author author = new Author("2", "Bibesh", "https://www.mkyong.com/wp-content/uploads/2013/10/Calendar.png");
        CustomMessage message = new CustomMessage("2", "HELLO", author, new Date());

        ImageLoader image = new ImageLoader() {
            @Override
            public void loadImage(ImageView imageView, String url) {
                Picasso.with(getContext()).load(url).into(imageView);
            }
        };
        adapter = new MessagesListAdapter<>("2", image);
        adapter.setOnMessageClickListener(this);
        adapter.setOnMessageViewClickListener(this);
        customMessageList.setAdapter(adapter);

        adapter.addToStart(message, true);
        return view;
    }

    @Override
    public boolean onSubmit(CharSequence input) {
        Author author = new Author("1", "Bibesh", "https://image.prntscr.com/image/_pzXGX-ySf6N2hoeFjMeXQ.png");
        CustomMessage message = new CustomMessage("2", input.toString(), author, new Date());
        adapter.addToStart(message, true);
        return true;
    }

    @Override
    public void onMessageClick(IMessage message) {
        Toast.makeText(getContext(), "MES"+message.toString(), Toast.LENGTH_SHORT).show();
        adapter.deleteById(message.getId());
    }

    @Override
    public void onMessageViewClick(View view, IMessage message) {
        Toast.makeText(getContext(), "View"+message.toString(), Toast.LENGTH_SHORT).show();
    }
}

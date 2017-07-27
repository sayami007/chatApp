package com.a3callistos.chatapplication.model;

import com.stfalcon.chatkit.commons.models.IMessage;

import java.util.Date;

/**
 * Created by Bibesh on 7/27/17.
 */

public class CustomMessage implements IMessage {

    public CustomMessage(String id, String text, Author user, Date createdAt) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.createdAt = createdAt;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public Author getUser() {
        return user;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    private String id;
    private String text;
    private Author user;
    private Date createdAt;

}
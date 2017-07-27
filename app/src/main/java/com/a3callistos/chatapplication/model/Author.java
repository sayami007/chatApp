package com.a3callistos.chatapplication.model;

import com.stfalcon.chatkit.commons.models.IUser;

/**
 * Created by Bibesh on 7/27/17.
 */

public class Author implements IUser {

    private String id;
    private String name;
    private String avatar;

    public Author(String id, String name, String avatar) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAvatar() {
        return avatar;
    }
}

package com.example.roomsimpleappwithjava.Model.room.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.roomsimpleappwithjava.Model.domine.User;

@Entity(tableName = "post_table")
public class Post {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public User user;
    public String title;
    public String body;

    public Post(User user, String title, String body) {
        this.user = user;
        this.title = title;
        this.body = body;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post() {
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}

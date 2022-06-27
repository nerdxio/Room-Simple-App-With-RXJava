package com.example.roomsimpleappwithjava.Model.room.converters;

import androidx.room.TypeConverter;

import com.example.roomsimpleappwithjava.Model.domine.User;
import com.google.gson.Gson;

public class Converter {

    @TypeConverter
    public   String fromUserToGson(User user){
        return new Gson().toJson(user);
    }
    @TypeConverter
    public  User fromGsonToUser(String stringUser){
        return new Gson().fromJson(stringUser,User.class);
    }
}

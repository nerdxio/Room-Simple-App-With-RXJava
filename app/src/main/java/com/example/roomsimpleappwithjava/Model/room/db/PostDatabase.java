package com.example.roomsimpleappwithjava.Model.room.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.roomsimpleappwithjava.Model.room.converters.Converter;
import com.example.roomsimpleappwithjava.Model.room.dao.PostDao;
import com.example.roomsimpleappwithjava.Model.room.entity.Post;

@Database(entities = {Post.class},version = 1)
@TypeConverters(Converter.class)
public  abstract class PostDatabase extends RoomDatabase {
    private static PostDatabase instance;
    public abstract PostDao  postDao();

    //singleton design pattern
    public  static synchronized PostDatabase getInstance(Context context){
        if(instance == null){
            instance  = Room.databaseBuilder(context.getApplicationContext()
                     ,PostDatabase.class,"posts_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
            return instance;

    }
}

package com.example.roomsimpleappwithjava.Model.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roomsimpleappwithjava.Model.room.entity.Post;

import java.util.List;
import android.database.Observable;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface PostDao {

    @Query("SELECT * FROM post_table")
    Single<List<Post>> getPosts();

    @Insert
    Completable insertPost(Post post);

    @Delete
    void delete(Post post);

}

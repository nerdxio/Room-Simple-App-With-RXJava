package com.example.roomsimpleappwithjava.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomsimpleappwithjava.Model.domine.User;
import com.example.roomsimpleappwithjava.Model.room.db.PostDatabase;
import com.example.roomsimpleappwithjava.Model.room.entity.Post;
import com.example.roomsimpleappwithjava.R;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    Button insert, get;
    EditText title, body;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        insert = findViewById(R.id.main_inset);
        get = findViewById(R.id.main_get);
        title = findViewById(R.id.main_titel);
        body = findViewById(R.id.main_body);
        recyclerView = findViewById(R.id.rv);

        PostAdapter adapter = new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        //database usage
        final PostDatabase database = PostDatabase.getInstance(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database.postDao().insertPost(new Post(new User(3,"hassan"), title.getText().toString(), body.getText().toString()))
                        .subscribeOn(Schedulers.computation())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onComplete() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });

            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                database.postDao().getPosts()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<List<Post>>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onSuccess(List<Post> posts) {
                                adapter.setList(posts);
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        });


            }
        });

    }
}
package com.example.retrofit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.retrofit.R;
import com.example.retrofit.ui.activities.CreatePostActivity;
import com.example.retrofit.ui.activities.DeletePostActivity;
import com.example.retrofit.ui.activities.ManyCommentsActivity;
import com.example.retrofit.ui.activities.ManyPostsActivity;
import com.example.retrofit.ui.activities.OnePostActivity;
import com.example.retrofit.ui.activities.OnePostDynamicallyActivity;
import com.example.retrofit.ui.activities.PutPostActivity;
import com.example.retrofit.ui.activities.UserPostsActivity;

public class MainActivity extends AppCompatActivity {

    Button btnGetManyPosts, btnGetOnePost, btnGetComments, btnGetOnePostDynamically, btnGetUserPosts,
            btnCreatePost, btnPutPost, btnDeletePost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getData();
    }

    public void init() {
        btnGetManyPosts = findViewById(R.id.btnGetPosts);
        btnGetOnePost = findViewById(R.id.btnGetOnePost);
        btnGetComments = findViewById(R.id.btnGetComments);
        btnGetOnePostDynamically = findViewById(R.id.btnGetOnePostDynamically);
        btnGetUserPosts = findViewById(R.id.btnGetUserPosts);

        btnCreatePost = findViewById(R.id.btnCreatePost);
        btnPutPost = findViewById(R.id.btnPutPost);

        btnDeletePost = findViewById(R.id.btnDeletePost);
    }

    public void getData() {

        btnGetManyPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ManyPostsActivity.class));
            }
        });

        btnGetOnePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OnePostActivity.class));
            }
        });

        btnGetComments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ManyCommentsActivity.class));
            }
        });

        btnGetOnePostDynamically.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, OnePostDynamicallyActivity.class));
            }
        });

        btnGetUserPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UserPostsActivity.class));
            }
        });

        btnCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreatePostActivity.class));
            }
        });

        btnPutPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PutPostActivity.class));
            }
        });

        btnDeletePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DeletePostActivity.class));
            }
        });
    }
}

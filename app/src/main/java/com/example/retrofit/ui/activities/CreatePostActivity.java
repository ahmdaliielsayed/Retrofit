package com.example.retrofit.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit.db.APIClient;
import com.example.retrofit.db.dao.APIInterface;
import com.example.retrofit.db.entity.Post;
import com.example.retrofit.R;
import com.example.retrofit.ui.viewmodel.CreatePostViewModel;
import com.example.retrofit.ui.viewmodel.UserPostsViewModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreatePostActivity extends AppCompatActivity {

    Button btnCreatePost;

    TextView textView;

    ProgressBar progressBar;

    CreatePostViewModel createPostViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        init();
        getData();
    }

    public void init() {
        btnCreatePost = findViewById(R.id.btnCreatePost);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        // View Model
        createPostViewModel = ViewModelProviders.of(this).get(CreatePostViewModel.class);
    }

    public void getData() {

//        btnCreatePost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
//                Post post = new Post(1, "Ahmed Ali", "Create Post Using Retrofit and MVVM");
//                createPostViewModel.createPostLiveData(post).observe(CreatePostActivity.this, new Observer<Post>() {
//                    @Override
//                    public void onChanged(Post post) {
//                        if (post != null) {
//                            progressBar.setVisibility(View.GONE);
//                            textView.setText("title: " + post.getTitle() + "\nbody: " + post.getBody());
//                        } else {
//                            // error or make method to show the specified error
//                        }
//                    }
//                });
//            }
//        });

//        btnCreatePost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
//
//                HashMap<String, String> map = new HashMap<>();
//                map.put("title", "Ahmed Ali");
//                map.put("body", "Create Post Using Retrofit");
//                map.put("userId", "1");
//
//                createPostViewModel.createGeneralPostLiveData(map).observe(CreatePostActivity.this, new Observer<Post>() {
//                    @Override
//                    public void onChanged(Post post) {
//                        if (post != null) {
//                            progressBar.setVisibility(View.GONE);
//                            textView.setText("title: " + post.getTitle() + "\nbody: " + post.getBody());
//                        } else {
//                            // error or make method to show the specified error
//                        }
//                    }
//                });
//            }
//        });

        btnCreatePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                createPostViewModel.createPost(23, "New Title", "New Text Body").observe(CreatePostActivity.this, new Observer<Post>() {
                    @Override
                    public void onChanged(Post post) {
                        if (post != null) {
                            progressBar.setVisibility(View.GONE);
                            textView.setText("title: " + post.getTitle() + "\nbody: " + post.getBody());
                        } else {
                            // error or make method to show the specified error
                        }
                    }
                });
            }
        });
    }
}

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
import com.example.retrofit.ui.viewmodel.PutPostViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PutPostActivity extends AppCompatActivity {

    Button btnPutPost;

    TextView textView;

    ProgressBar progressBar;

    PutPostViewModel putPostViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_post);

        init();
        getData();
    }

    public void init() {
        btnPutPost = findViewById(R.id.btnPutPost);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        // View Model
        putPostViewModel = ViewModelProviders.of(this).get(PutPostViewModel.class);
    }

    private void getData() {
//        btnPutPost.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
//
//                Post post = new Post(12, null, "New Text");
//
//                putPostViewModel.putPostLiveData(5, post).observe(PutPostActivity.this, new Observer<Post>() {
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

        btnPutPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                Post post = new Post(12, null, "New Text");

                putPostViewModel.patchPostLiveData(5, post).observe(PutPostActivity.this, new Observer<Post>() {
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

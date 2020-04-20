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
import com.example.retrofit.ui.viewmodel.OnePostDynamicallyViewModel;
import com.example.retrofit.ui.viewmodel.OnePostViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnePostDynamicallyActivity extends AppCompatActivity {

    Button btnGetPostDynamic;

    TextView textView;

    ProgressBar progressBar;

    OnePostDynamicallyViewModel onePostDynamicallyViewModel;

    int postId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_post_dynamically);

        init();
        getData();
    }

    public void init() {
        postId = 1;
        btnGetPostDynamic = findViewById(R.id.btnGetPostDynamic);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        // view model
        onePostDynamicallyViewModel = ViewModelProviders.of(this).get(OnePostDynamicallyViewModel.class);
    }

    public void getData() {

        btnGetPostDynamic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                onePostDynamicallyViewModel.getOnePostDynamicallyLiveData(postId).observe(OnePostDynamicallyActivity.this, new Observer<Post>() {
                    @Override
                    public void onChanged(Post post) {
                        if (post != null) {
                            btnGetPostDynamic.setText("" + postId);
                            progressBar.setVisibility(View.GONE);
                            textView.setText(post.getTitle());
                            postId++;
                        } else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(OnePostDynamicallyActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}

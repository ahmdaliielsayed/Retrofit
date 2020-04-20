package com.example.retrofit.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.retrofit.db.APIClient;
import com.example.retrofit.db.dao.APIInterface;
import com.example.retrofit.db.entity.Post;
import com.example.retrofit.R;
import com.example.retrofit.ui.viewmodel.OnePostViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OnePostActivity extends AppCompatActivity {

    TextView textView;

    ProgressBar progressBar;

    OnePostViewModel onePostViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_post);

        init();
        getData();
    }

    public void init() {
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        // view model
        onePostViewModel = ViewModelProviders.of(this).get(OnePostViewModel.class);
    }

    public void getData() {

        onePostViewModel.getOnePostLiveData().observe(this, new Observer<Post>() {
            @Override
            public void onChanged(Post post) {
                if (post != null) {
                    progressBar.setVisibility(View.GONE);
                    textView.setText(post.getTitle());
                } else {
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(OnePostActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

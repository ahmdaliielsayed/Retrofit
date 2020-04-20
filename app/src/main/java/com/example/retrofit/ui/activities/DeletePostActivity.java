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
import com.example.retrofit.R;
import com.example.retrofit.db.entity.Post;
import com.example.retrofit.ui.viewmodel.DeletePostViewModel;
import com.example.retrofit.ui.viewmodel.PutPostViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DeletePostActivity extends AppCompatActivity {

    Button btnDeletePost;

    TextView textView;

    ProgressBar progressBar;

    DeletePostViewModel deletePostViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_post);

        init();
        getData();
    }

    public void init() {
        btnDeletePost = findViewById(R.id.btnDeletePost);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progressBar);

        // View Model
        deletePostViewModel = ViewModelProviders.of(this).get(DeletePostViewModel.class);
    }

    private void getData() {
        btnDeletePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                deletePostViewModel.deletePostLiveData(5).observe(DeletePostActivity.this, new Observer<Void>() {
                    @Override
                    public void onChanged(Void aVoid) {
                        progressBar.setVisibility(View.GONE);
                        textView.setText("Done: deleted successfully");
                    }
                });
            }
        });
    }
}

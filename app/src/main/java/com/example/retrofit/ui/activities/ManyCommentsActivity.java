package com.example.retrofit.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.retrofit.db.APIClient;
import com.example.retrofit.db.dao.APIInterface;
import com.example.retrofit.db.entity.Post;
import com.example.retrofit.ui.adapter.CommentAdapter;
import com.example.retrofit.db.entity.Comment;
import com.example.retrofit.R;
import com.example.retrofit.ui.viewmodel.ManyCommentsViewModel;
import com.example.retrofit.ui.viewmodel.ManyPostsViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManyCommentsActivity extends AppCompatActivity {

    ProgressBar progressBar;

    RecyclerView myRecyclerView;
    CommentAdapter commentAdapter;

    ManyCommentsViewModel manyCommentsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_many_comments);

        init();
        getData();
    }

    public void init() {
        progressBar = findViewById(R.id.progressBar);
        myRecyclerView = findViewById(R.id.recycleView);

        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(linearLayoutManager);

//        // use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        myRecyclerView.setHasFixedSize(true);

        // adapter
        commentAdapter = new CommentAdapter(this);
        myRecyclerView.setAdapter(commentAdapter);

        // View Model
        manyCommentsViewModel = ViewModelProviders.of(this).get(ManyCommentsViewModel.class);
    }

    public void getData() {

        manyCommentsViewModel.getManyCommentsLiveData().observe(this, new Observer<ArrayList<Comment>>() {
            @Override
            public void onChanged(ArrayList<Comment> comments) {
                if (comments != null) {
                    progressBar.setVisibility(View.GONE);
                    fillData(comments);
                } else {
                    // error or make method to show the specified error
                }
            }
        });
    }

    public void fillData(ArrayList<Comment> dataModelList) {
        commentAdapter.setDataToAdapter(dataModelList);
    }
}

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
import com.example.retrofit.R;
import com.example.retrofit.ui.adapter.UserAdapter;
import com.example.retrofit.ui.viewmodel.ManyPostsViewModel;
import com.example.retrofit.ui.viewmodel.OnePostDynamicallyViewModel;
import com.example.retrofit.ui.viewmodel.UserPostsViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPostsActivity extends AppCompatActivity {

    ProgressBar progressBar;

    RecyclerView myRecyclerView;
    UserAdapter userAdapter;

    UserPostsViewModel userPostsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_posts);

        init();
        getData();
    }

    public void init() {
        progressBar = findViewById(R.id.progressBar);
        myRecyclerView = findViewById(R.id.recyvleView);

        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(linearLayoutManager);

//        // use this setting to improve performance if you know that changes
//        // in content do not change the layout size of the RecyclerView
//        myRecyclerView.setHasFixedSize(true);

        // adapter
        userAdapter = new UserAdapter(this);
        myRecyclerView.setAdapter(userAdapter);

        // View Model
        userPostsViewModel = ViewModelProviders.of(this).get(UserPostsViewModel.class);
    }

    public void getData() {

//        userPostsViewModel.getUserPostsLiveData("1").observe(this, new Observer<ArrayList<Post>>() {
//            @Override
//            public void onChanged(ArrayList<Post> posts) {
//                if (posts != null) {
//                    progressBar.setVisibility(View.GONE);
//                    fillData(posts);
//                } else {
//                    // error or make method to show the specified error
//                }
//            }
//        });

//        userPostsViewModel.getUserPostsLiveData(1, "id", "desc").observe(this, new Observer<ArrayList<Post>>() {
//            @Override
//            public void onChanged(ArrayList<Post> posts) {
//                if (posts != null) {
//                    progressBar.setVisibility(View.GONE);
//                    fillData(posts);
//                } else {
//                    // error or make method to show the specified error
//                }
//            }
//        });

//        userPostsViewModel.getUserPostsLiveData(1, 4, null, null).observe(this, new Observer<ArrayList<Post>>() {
//            @Override
//            public void onChanged(ArrayList<Post> posts) {
//                if (posts != null) {
//                    progressBar.setVisibility(View.GONE);
//                    fillData(posts);
//                } else {
//                    // error or make method to show the specified error
//                }
//            }
//        });

        Map<String, String> map = new HashMap<>();
        map.put("userId", "1");
        map.put("_sort", "id");
        map.put("_order", "desc");
        userPostsViewModel.getUserPostsLiveData(map).observe(this, new Observer<ArrayList<Post>>() {
            @Override
            public void onChanged(ArrayList<Post> posts) {
                if (posts != null) {
                    progressBar.setVisibility(View.GONE);
                    fillData(posts);
                } else {
                    // error or make method to show the specified error
                }
            }
        });
    }

    public void fillData(ArrayList<Post> dataModelList) {
        userAdapter.setDataToAdapter(dataModelList);
    }
}

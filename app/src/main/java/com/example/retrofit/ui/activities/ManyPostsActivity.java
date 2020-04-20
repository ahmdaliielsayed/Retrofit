package com.example.retrofit.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.retrofit.db.entity.Post;
import com.example.retrofit.R;
import com.example.retrofit.ui.adapter.UserAdapter;
import com.example.retrofit.ui.viewmodel.ManyPostsViewModel;

import java.util.ArrayList;

public class ManyPostsActivity extends AppCompatActivity {

    ProgressBar progressBar;

    RecyclerView myRecyclerView;
    UserAdapter userAdapter;

    ManyPostsViewModel manyPostsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_many_posts);

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

        // View Models
//        manyPostsViewModel = ViewModelProviders.of(this).get(ManyPostsViewModel.class);
        manyPostsViewModel = ViewModelProviders.of(this, new PostsViewModelFactory(ManyPostsActivity.this))
                .get(ManyPostsViewModel.class);

    }

    public void getData() {
        manyPostsViewModel.getManyPosts().observe(this, new Observer<ArrayList<Post>>() {
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

    public static void errorType(String errorType) {

    }

    public void errorMessage(String errorType) {
        Toast.makeText(getApplicationContext(), errorType, Toast.LENGTH_SHORT).show();
    }


    class PostsViewModelFactory implements ViewModelProvider.Factory {
        private ManyPostsActivity manyPostsActivity;


        public PostsViewModelFactory(ManyPostsActivity manyPostsActivity) {
            this.manyPostsActivity = manyPostsActivity;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ManyPostsViewModel(manyPostsActivity);
        }
    }

    class ViewModelFactory implements ViewModelProvider.Factory {

        private Activity activity;
        private Fragment fragment;

        public ViewModelFactory(Activity activity) {
            this.activity = activity;
        }

        public ViewModelFactory(Fragment fragment) {
            this.fragment = fragment;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (activity != null) {
                return (T) new ManyPostsViewModel(activity);
            } else {
                // fragment
//                return (T) new ManyPostsViewModel(fragment);
                return null;
            }
        }
    }
}

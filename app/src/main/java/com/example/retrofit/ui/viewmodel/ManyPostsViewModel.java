package com.example.retrofit.ui.viewmodel;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit.db.entity.Post;
import com.example.retrofit.repository.Repository;
import com.example.retrofit.ui.activities.ManyPostsActivity;

import java.util.ArrayList;

public class ManyPostsViewModel extends ViewModel {

    private Repository postRepository;
    private LiveData<ArrayList<Post>> manyPostsLiveData;

    private static ManyPostsActivity manyPostsActivity;

    public ManyPostsViewModel(Activity manyPostsActivity) {
        postRepository = new Repository();
        manyPostsLiveData = postRepository.getManyPosts();
        this.manyPostsActivity = (ManyPostsActivity) manyPostsActivity;
    }

    public LiveData<ArrayList<Post>> getManyPosts() {
        return manyPostsLiveData;
    }

    public static void errorMessage(String errorType) {
        System.out.println("error = " + errorType);
//        Toast.makeText(getApplicationContext(), errorType, Toast.LENGTH_SHORT).show();
        manyPostsActivity.errorMessage(errorType);
    }


}

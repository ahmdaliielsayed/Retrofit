package com.example.retrofit.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit.db.entity.Post;
import com.example.retrofit.repository.Repository;

import java.util.ArrayList;
import java.util.Map;

public class UserPostsViewModel  extends ViewModel {

    private Repository postRepository;
    private LiveData<ArrayList<Post>> userPostsLiveData;

    public UserPostsViewModel() {
        postRepository = new Repository();
    }

    public LiveData<ArrayList<Post>> getUserPostsLiveData(String id) {
        userPostsLiveData = postRepository.getUserPosts(id);
        return userPostsLiveData;
    }

    public LiveData<ArrayList<Post>> getUserPostsLiveData(Integer userId, String sort, String order) {
        userPostsLiveData = postRepository.getUserPosts(userId, sort, order);
        return userPostsLiveData;
    }

    public LiveData<ArrayList<Post>> getUserPostsLiveData(Integer userId, Integer userId2, String sort, String order) {
        userPostsLiveData = postRepository.getUserPosts(userId, userId2, sort, order);
        return userPostsLiveData;
    }

    public LiveData<ArrayList<Post>> getUserPostsLiveData(Map<String, String> map) {
        userPostsLiveData = postRepository.getUserPosts(map);
        return userPostsLiveData;
    }
}

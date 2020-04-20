package com.example.retrofit.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit.db.entity.Post;
import com.example.retrofit.repository.Repository;

import java.util.HashMap;

public class CreatePostViewModel extends ViewModel {

    private Repository postRepository;
    private LiveData<Post> createPostLiveData;

    public CreatePostViewModel() {
        postRepository = new Repository();
    }

    public LiveData<Post> createPostLiveData(Post post) {
        createPostLiveData = postRepository.createPost(post);
        return createPostLiveData;
    }

    public LiveData<Post> createGeneralPostLiveData(HashMap<String, String> map) {
        createPostLiveData = postRepository.createGeneralPost(map);
        return createPostLiveData;
    }

    public LiveData<Post> createPost(int userId, String title, String body) {
        createPostLiveData = postRepository.createPost(userId, title, body);
        return createPostLiveData;
    }
}

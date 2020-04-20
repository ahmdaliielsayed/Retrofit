package com.example.retrofit.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit.db.entity.Post;
import com.example.retrofit.repository.Repository;

public class PutPostViewModel extends ViewModel {

    private Repository postRepository;
    private LiveData<Post> putPostLiveData;

    public PutPostViewModel() {
        postRepository = new Repository();
    }

    public LiveData<Post> putPostLiveData(int id, Post post) {
        putPostLiveData = postRepository.putPost(id, post);
        return putPostLiveData;
    }

    public LiveData<Post> patchPostLiveData(int id, Post post) {
        putPostLiveData = postRepository.patchPost(id, post);
        return putPostLiveData;
    }
}

package com.example.retrofit.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit.db.entity.Post;
import com.example.retrofit.repository.Repository;

public class OnePostViewModel extends ViewModel {

    private Repository postRepository;
    private LiveData<Post> onePostLiveData;

    public OnePostViewModel() {
        postRepository = new Repository();
        onePostLiveData = postRepository.getOnePost();
    }

    public LiveData<Post> getOnePostLiveData() {
        return onePostLiveData;
    }
}

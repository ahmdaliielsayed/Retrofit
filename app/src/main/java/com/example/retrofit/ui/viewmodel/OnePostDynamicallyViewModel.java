package com.example.retrofit.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit.db.entity.Post;
import com.example.retrofit.repository.Repository;

public class OnePostDynamicallyViewModel extends ViewModel {

    private Repository postRepository;
    private LiveData<Post> onePostDynamicallyLiveData;

    public OnePostDynamicallyViewModel() {
        postRepository = new Repository();
    }

    public LiveData<Post> getOnePostDynamicallyLiveData(int id) {
        onePostDynamicallyLiveData = postRepository.getOnePostDynamically(id);
        return onePostDynamicallyLiveData;
    }
}

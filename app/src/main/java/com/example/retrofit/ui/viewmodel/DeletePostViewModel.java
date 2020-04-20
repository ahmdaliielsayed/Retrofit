package com.example.retrofit.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit.db.entity.Post;
import com.example.retrofit.repository.Repository;

public class DeletePostViewModel extends ViewModel {

    private Repository postRepository;
    private LiveData<Void> deletePostLiveData;

    public DeletePostViewModel() {
        postRepository = new Repository();
    }

    public LiveData<Void> deletePostLiveData(int id) {
        deletePostLiveData = postRepository.deletePost(id);
        return deletePostLiveData;
    }
}

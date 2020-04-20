package com.example.retrofit.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit.db.entity.Comment;
import com.example.retrofit.repository.Repository;

import java.util.ArrayList;

public class ManyCommentsViewModel extends ViewModel {

    private Repository postRepository;
    private LiveData<ArrayList<Comment>> manyCommentsLiveData;

    public ManyCommentsViewModel() {
        postRepository = new Repository();
        manyCommentsLiveData =postRepository.getManyComments();
    }

    public LiveData<ArrayList<Comment>> getManyCommentsLiveData() {
        return manyCommentsLiveData;
    }
}

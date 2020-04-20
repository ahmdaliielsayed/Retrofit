package com.example.retrofit.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.retrofit.db.APIClient;
import com.example.retrofit.db.dao.APIInterface;
import com.example.retrofit.db.entity.Comment;
import com.example.retrofit.db.entity.Post;
import com.example.retrofit.ui.viewmodel.ManyPostsViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private APIInterface apiInterface;

    public Repository() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
    }

    public LiveData<ArrayList<Post>> getManyPosts() {
        final MutableLiveData<ArrayList<Post>> manyPostsMutableLiveData = new MutableLiveData<>();
        apiInterface.getPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()) {
                    manyPostsMutableLiveData.setValue(response.body());
                } else {
                    // error
                    ManyPostsViewModel.errorMessage("something wrong");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                t.printStackTrace();
                // error
                ManyPostsViewModel.errorMessage(t.getMessage());
            }
        });
        return manyPostsMutableLiveData;
    }

    public LiveData<Post> getOnePost() {
        final MutableLiveData<Post> onePostMutableLiveData = new MutableLiveData<>();
        apiInterface.getPost().enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    onePostMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
                // error
                // onePostMutableLiveData.setValue(null);
            }
        });
        return onePostMutableLiveData;
    }

    public LiveData<ArrayList<Comment>> getManyComments() {
        final MutableLiveData<ArrayList<Comment>> manyCommentsMutableLiveData = new MutableLiveData<>();
        apiInterface.getComments().enqueue(new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                if (response.isSuccessful()) {
                    manyCommentsMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {
                t.printStackTrace();
                // error
                // manyCommentsMutableLiveData.setValue(null);
            }
        });

        return manyCommentsMutableLiveData;
    }

    public LiveData<Post> getOnePostDynamically(int id) {
        final MutableLiveData<Post> onePostDynamicallyMutableLiveData = new MutableLiveData<>();
        apiInterface.getPost(id).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    onePostDynamicallyMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
                // error
                // onePostDynamicallyMutableLiveData.setValue(null);
            }
        });
        return onePostDynamicallyMutableLiveData;
    }

    public LiveData<ArrayList<Post>> getUserPosts(String id) {
        final MutableLiveData<ArrayList<Post>> userPostsMutableLiveData = new MutableLiveData<>();
        apiInterface.getPost(id).enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()) {
                    userPostsMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                t.printStackTrace();
                // error
                // userPostsMutableLiveData.setValue(null);
            }
        });
        return userPostsMutableLiveData;
    }

    public LiveData<ArrayList<Post>> getUserPosts(Integer userId, String sort, String order) {
        final MutableLiveData<ArrayList<Post>> userPostsMutableLiveData = new MutableLiveData<>();
        apiInterface.getPost(userId, sort, order).enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()) {
                    userPostsMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                t.printStackTrace();
                // error
                // userPostsMutableLiveData.setValue(null);
            }
        });
        return userPostsMutableLiveData;
    }

    public LiveData<ArrayList<Post>> getUserPosts(Integer userId, Integer userId2, String sort, String order) {
        final MutableLiveData<ArrayList<Post>> userPostsMutableLiveData = new MutableLiveData<>();
        apiInterface.getPost(userId, userId2, sort, order).enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()) {
                    userPostsMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                t.printStackTrace();
                // error
                // userPostsMutableLiveData.setValue(null);
            }
        });
        return userPostsMutableLiveData;
    }

    public LiveData<ArrayList<Post>> getUserPosts(Map<String, String> map) {
        final MutableLiveData<ArrayList<Post>> userPostsMutableLiveData = new MutableLiveData<>();
        apiInterface.getPost(map).enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                if (response.isSuccessful()) {
                    userPostsMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                t.printStackTrace();
                // error
                // userPostsMutableLiveData.setValue(null);
            }
        });
        return userPostsMutableLiveData;
    }

    public LiveData<Post> createPost(Post post) {
        final MutableLiveData<Post> postMutableLiveData = new MutableLiveData<>();
        apiInterface.createPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    postMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
                // error
                // postMutableLiveData.setValue(null);
            }
        });
        return postMutableLiveData;
    }

    public LiveData<Post> createGeneralPost(HashMap<String, String> map) {
        final MutableLiveData<Post> postMutableLiveData = new MutableLiveData<>();
        apiInterface.createGeneralPost(map).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    postMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
                // error
                // postMutableLiveData.setValue(null);
            }
        });
        return postMutableLiveData;
    }

    public LiveData<Post> createPost(int userId, String title, String body) {
        final MutableLiveData<Post> postMutableLiveData = new MutableLiveData<>();
        apiInterface.createPost(userId, title, body).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    postMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
                // error
                // postMutableLiveData.setValue(null);
            }
        });
        return postMutableLiveData;
    }

    public LiveData<Post> putPost(int id, Post post) {
        final MutableLiveData<Post> postMutableLiveData = new MutableLiveData<>();
        apiInterface.putPost(id, post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    postMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
                // error
                // postMutableLiveData.setValue(null);
            }
        });
        return postMutableLiveData;
    }

    public LiveData<Post> patchPost(int id, Post post) {
        final MutableLiveData<Post> postMutableLiveData = new MutableLiveData<>();
        apiInterface.patchPost(id, post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (response.isSuccessful()) {
                    postMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t.printStackTrace();
                // error
                // postMutableLiveData.setValue(null);
            }
        });
        return postMutableLiveData;
    }

    public LiveData<Void> deletePost(int id) {
        final MutableLiveData<Void> postMutableLiveData = new MutableLiveData<>();
        apiInterface.deletePost(id).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    postMutableLiveData.setValue(response.body());
                } else {
                    // error
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
                // error
                // postMutableLiveData.setValue(null);
            }
        });
        return postMutableLiveData;
    }
}

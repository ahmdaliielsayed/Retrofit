package com.example.retrofit.db.dao;

import com.example.retrofit.db.entity.Comment;
import com.example.retrofit.db.entity.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIInterface {

    @GET("posts")
    Call<ArrayList<Post>> getPosts();

    @GET("posts/1")
    Call<Post> getPost();

    @GET("posts/1/comments")
    Call<ArrayList<Comment>> getComments();

    @GET("posts/{id}")
    Call<Post> getPost(@Path("id") int id);

    // call1
    @GET("posts")
    Call<ArrayList<Post>> getPost(@Query("userId") String userId);

    // call2
    @GET("posts")
    Call<ArrayList<Post>> getPost(
            @Query("userId") Integer userId,
            @Query("_sort") String sort,
            @Query("_order") String order);

    // call3
    @GET("posts")
    Call<ArrayList<Post>> getPost(
            @Query("userId") Integer userId,
            @Query("userId") Integer userId2,
            @Query("_sort") String sort,
            @Query("_order") String order);

    // call4
    @GET("posts")
    Call<ArrayList<Post>> getPost(@QueryMap Map<String, String> map);

    // Create a resource
    @POST("posts")
    Call<Post> createPost(@Body Post post);

    // Create a general resource
    @POST("posts")
    Call<Post> createGeneralPost(@Body HashMap<String, String> map);

    // Create a specific fields to resource with each field separated from another
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String body);

    // Update a resource
    @PUT("posts/{id}") // update all the post
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    @PATCH("posts/{id}") // update specific values
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);
}

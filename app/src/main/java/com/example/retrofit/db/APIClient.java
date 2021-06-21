package com.example.retrofit.db;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    private static Retrofit retrofit;

    public static Retrofit getClient(){
        if (retrofit == null) {
            synchronized (APIClient.class) {
                if (retrofit == null) {
                    // optional steps but very important in debugging
                    Gson gson = new GsonBuilder().serializeNulls().create();

                    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

                    OkHttpClient okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(loggingInterceptor)
                            .build();
                    // optional steps but very important in debugging

                    retrofit = new Retrofit.Builder()
                            .baseUrl("https://jsonplaceholder.typicode.com/")
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .client(okHttpClient)
                            .build();
                }
            }
        }
        return retrofit;
    }
}

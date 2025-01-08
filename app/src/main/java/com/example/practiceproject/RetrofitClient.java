package com.example.practiceproject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// APIのBaseURL取得
public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://openlibrary.org/developers/api")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

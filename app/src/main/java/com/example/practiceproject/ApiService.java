package com.example.practiceproject;

import retrofit2.Call;
import retrofit2.http.GET;

// API取得インターフェース
public interface ApiService {
    // リスト作成API取得
    @GET("/lists#create-list")
    Call<ListsResponse> getPost();
}

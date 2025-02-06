package com.example.practiceproject.model;

import retrofit2.Call;
import retrofit2.http.GET;

// API取得インターフェース
public interface ApiService {
    // リスト作成API取得
    @GET("/people/george08/lists.json")
    Call<ListsResponse> getResponse();
}

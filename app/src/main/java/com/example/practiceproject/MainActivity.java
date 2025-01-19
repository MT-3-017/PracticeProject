package com.example.practiceproject;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ApiServiceインスタンスの作成
        apiService = RetrofitClient.getClient().create(ApiService.class);

        // API呼び出し
        Call<ListsResponse> call = apiService.getResponse();
        // 非同期リクエストの実行
        call.enqueue(new Callback<ListsResponse>() {
            @Override
            public void onResponse(Call<ListsResponse> call, Response<ListsResponse> response) {
                if (response.isSuccessful()) {
                    // 成功時の処理
                    ListsResponse apiResponse = response.body();
                    if (apiResponse != null) {
                        System.out.println("Size: " + apiResponse.getSize());
                        System.out.println("First Entry Name: " + apiResponse.getEntries().get(0).getName());
                    }
                } else {
                    // エラーハンドリング
                    System.err.println("Request failed with code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ListsResponse> call, Throwable t) {
                System.err.println("API呼び出し失敗");
            }
        });
    }
}
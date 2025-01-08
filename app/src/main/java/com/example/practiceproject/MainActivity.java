package com.example.practiceproject;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
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
        Call<ListsResponse> call = apiService.getPost();
        ApiClient.makeApiCall(call, new ApiClient.ApiResponseListener<ListsResponse>() {
            @Override
            public void onSuccess(ListsResponse data) {
                // 成功時の処理
                Log.d("MainActivity", "API Success: " + data.toString());
            }

            @Override
            public void onError(String error) {
                // エラー時の処理
                Log.e("MainActivity", "API Error: " + error);
            }
        });
    }
}
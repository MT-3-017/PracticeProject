package com.example.practiceproject.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.practiceproject.model.ApiService;
import com.example.practiceproject.model.ListsResponse;
import com.example.practiceproject.model.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiDataViewModel extends ViewModel {
    private ApiService apiService;

    public ApiDataViewModel() {
        // ApiServiceインスタンスの作成
        apiService = RetrofitClient.getApiService();
        apiService = RetrofitClient.getClient().create(ApiService.class);
    }

    /**
     * MyList取得処理
     */
    public void fetchMyListData() {
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

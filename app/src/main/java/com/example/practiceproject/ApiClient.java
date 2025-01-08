package com.example.practiceproject;

import android.util.Log;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// APIのレスポンスデータ取得結果
public class ApiClient {
    private static final String TAG = "ApiClient";

    public static <T> void makeApiCall(Call<T> call, final ApiResponseListener<T> listener) {
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if (response.isSuccessful()) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onError("Error: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                listener.onError("Failure: " + t.getMessage());
                Log.e(TAG, "API call failure", t);
            }
        });
    }

    public interface ApiResponseListener<T> {
        void onSuccess(T data);
        void onError(String error);
    }
}

package com.example.practiceproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.practiceproject.model.ApiService;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fragmentを追加
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_top, new MyListDataFragment())
                    .commit();
        }
    }
}
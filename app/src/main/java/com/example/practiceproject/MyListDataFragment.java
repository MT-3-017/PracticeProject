package com.example.practiceproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.practiceproject.viewmodel.ApiDataViewModel;

public class MyListDataFragment extends Fragment {
    private ApiDataViewModel apiDataViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_list_data, container, false);

        apiDataViewModel = new ViewModelProvider(requireActivity()).get(ApiDataViewModel.class);

        // データを取得
        apiDataViewModel.fetchMyListData();

        return rootView;
    }
}

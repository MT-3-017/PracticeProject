package com.example.practiceproject;

// Lists APIのレスポンスデータ：読書リスト
public class ListsResponse {
    private String links;
    private int size;
    private String[] entries;

    public ListsResponse(String links, int size, String[] entries) {
        super();
        this.links = links;
        this.size = size;
        this.entries = entries;
    }
}

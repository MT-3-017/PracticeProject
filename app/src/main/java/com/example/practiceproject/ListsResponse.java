package com.example.practiceproject;

import java.util.List;

// Lists APIのレスポンスデータ：読書リスト
public class ListsResponse {
    private Links links;
    private int size;
    private List<Entry> entries;

    // Getter/Setters定義
    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    // Linksクラス
    public static class Links {
        private String self;
        private String next;

        // Getters/Setters定義
        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }
    }

    // Entryクラス
    public static class Entry {
        private String url;
        private String fullUrl;
        private String name;
        private String lastUpdate;
        private int seedCount;
        private int editionCount;

        // Getter/Setters定義
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFullUrl() {
            return fullUrl;
        }

        public void setFullUrl(String fullUrl) {
            this.fullUrl = fullUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastUpdate() {
            return lastUpdate;
        }

        public void setLastUpdate(String lastUpdate) {
            this.lastUpdate = lastUpdate;
        }

        public int getSeedCount() {
            return seedCount;
        }

        public void setSeedCount(int seedCount) {
            this.seedCount = seedCount;
        }

        public int getEditionCount() {
            return editionCount;
        }

        public void setEditionCount(int editionCount) {
            this.editionCount = editionCount;
        }
    }
}

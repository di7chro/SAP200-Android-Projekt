package com.example.spinnermenu;

public class SpinnerItem {
    private String title;
    private String url;

    public SpinnerItem(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return title; // Så att Spinner visar titeln
    }
}

package com.example.converter;

public class Articles {
    String url,title,description,image;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Articles(String url, String title, String description, String image) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.image = image;
    }
}

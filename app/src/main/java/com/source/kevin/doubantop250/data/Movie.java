package com.source.kevin.doubantop250.data;

/**
 * 一个电影对象,包含标题和图片URL
 */
public class Movie {
    String title;
    MovieImage images;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public MovieImage getImages() {
        return images;
    }
    public void setImages(MovieImage images) {
        this.images = images;
    }

}

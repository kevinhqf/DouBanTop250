package com.source.kevin.doubantop250.data;


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

    class MovieImage{
        String small;
        String large;
        String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }
}

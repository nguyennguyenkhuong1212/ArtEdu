package com.example.artedu.models;

import androidx.annotation.NonNull;

public class Painting {
    private String title;
    private String description;
    private int imageResId;
    private String artist;
    private String year;
    private String medium;
    private String location;

    public Painting(String title, String description, int imageResId, String artist, String year, String medium, String location) {
        this.title = title;
        this.description = description;
        this.imageResId = imageResId;
        this.artist = artist;
        this.year = year;
        this.medium = medium;
        this.location = location;
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

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @NonNull
    @Override
    public String toString() {
        return "Painting{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imageResId=" + imageResId +
                ", artist='" + artist + '\'' +
                ", year='" + year + '\'' +
                ", medium='" + medium + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

package com.test.test.Entities;

import com.google.gson.annotations.SerializedName;

public class Book {
    private int id;
    @SerializedName("nombre")
    private String name;
    @SerializedName("autor")
    private String author;
    @SerializedName("disponibilidad")
    private boolean availability;
    @SerializedName("popularidad")
    private int popularity;
    @SerializedName("imagen")
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

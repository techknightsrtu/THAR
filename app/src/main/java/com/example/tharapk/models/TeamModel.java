package com.example.tharapk.models;

public class TeamModel {
    private String name, Title,image;

    public TeamModel() {
    }

    public TeamModel(String name, String Title) {
        this.name = name;
        this.Title = Title;
        this.image = image;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return Title;
    }
//
    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
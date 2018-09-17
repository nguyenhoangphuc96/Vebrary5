package com.lacviet.vebrary5.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsModel {


    private String id;

    private String title;

    private String author;

    private String description;
    private String publishedDate;

    private String itemImg;

    public NewsModel(String id, String title, String author, String description, String publishedDate, String itemImg) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.publishedDate = publishedDate;
        this.itemImg = itemImg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }
}

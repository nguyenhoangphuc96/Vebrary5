package com.lacviet.vebrary5.Model;

public class ResultItemModel {
    String id;
    String title;
    String author;
    String image;
    int total;
    int circulate;
    int available;

    public ResultItemModel(String id, String title, String author, String image, int total, int circulate, int available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.image = image;
        this.total = total;
        this.circulate = circulate;
        this.available = available;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCirculate() {
        return circulate;
    }

    public void setCirculate(int circulate) {
        this.circulate = circulate;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}

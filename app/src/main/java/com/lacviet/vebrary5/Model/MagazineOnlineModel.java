package com.lacviet.vebrary5.Model;

public class MagazineOnlineModel {
    String id;
    String title;
    Integer total;
    String image;


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

    public Integer getTotal() {
        return total;
    }


    public void setTotal(Integer total) {
        total = total;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public MagazineOnlineModel(String id, String title, Integer total, String image) {
        this.id = id;
        this.title = title;
        this.total = total;
        this.image = image;
    }
}

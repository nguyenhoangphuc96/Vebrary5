package com.lacviet.vebrary5.Model;

public class SerialMagazineModel {
    String id;
    String title;
    String serial;
    String image;

    public SerialMagazineModel(String id, String title, String serial, String image) {
        this.id = id;
        this.title = title;
        this.serial = serial;
        this.image = image;
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

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

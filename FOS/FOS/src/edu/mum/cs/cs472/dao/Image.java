package edu.mum.cs.cs472.dao;

import java.util.Date;

public class Image {

    private int imageId;

    private String path;

    private Date date;

    public Image() {
    }

    public Image(int imageId, String path, Date date) {
        this.imageId = imageId;
        this.path = path;
        this.date = date;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

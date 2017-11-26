package com.xpy.administrator.probityeducation.model;

/**
 * Created by Administrator on 2017/11/3.
 */

public class ImageTitleModel {
    private int imageId;
    private String title;

    public ImageTitleModel(int imageId, String title) {
        this.imageId = imageId;
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package com.xpy.administrator.probityeducation.model;

/**
 * Created by Administrator on 2017/11/3.
 */

public class ContentImageTitleModel {
    private int imageId;
    private String title;
    private String content;

    public ContentImageTitleModel(int imageId, String title, String content) {
        this.imageId = imageId;
        this.title = title;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

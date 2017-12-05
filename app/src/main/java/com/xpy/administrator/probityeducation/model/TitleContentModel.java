package com.xpy.administrator.probityeducation.model;

/**
 * Created by Administrator on 2017/12/2.
 */

public class TitleContentModel {
    private String title;
    private String content;

    public TitleContentModel(String title, String content) {
        this.title = title;
        this.content = content;
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

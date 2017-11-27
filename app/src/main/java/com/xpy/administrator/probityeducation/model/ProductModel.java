package com.xpy.administrator.probityeducation.model;

/**
 * Created by Administrator on 2017/11/27.
 */

public class ProductModel {

    /**
     * id : 1
     * product_name : 书端州群斋壁
     * banji : 17计科4
     * author : 郭露露
     * department : 信工院班
     * product_path : /ProbityEducationServer/products_image/1.jpg
     * type : 书法
     * tel : 15151825953
     */

    private String id;
    private String product_name;
    private String banji;
    private String author;
    private String department;
    private String product_path;
    private String type;
    private String tel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBanji() {
        return banji;
    }

    public void setBanji(String banji) {
        this.banji = banji;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProduct_path() {
        return product_path;
    }

    public void setProduct_path(String product_path) {
        this.product_path = product_path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

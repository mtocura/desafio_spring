package br.com.bootcamp.desafio_spring.form;

import java.util.Date;

public class PostForm {
    private int userId;
    private int id_post;
    private Date date;
    private ProductForm detail;
    private int category;
    private double price;

    public PostForm() {
    }

    public PostForm(int userId, int id_post, Date date, ProductForm detail, int category, double price) {
        this.userId = userId;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public int getId_post() {
        return id_post;
    }

    public Date getDate() {
        return date;
    }

    public ProductForm getDetail() {
        return detail;
    }

    public int getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

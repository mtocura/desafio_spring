package br.com.bootcamp.desafio_spring.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PostForm {
    @NotNull
    @NotEmpty
    private int userId;

    @NotNull
    @NotEmpty
    private int id_post;

    @NotNull
    @NotEmpty
    private Date date;

    @NotNull
    @NotEmpty
    private ProductForm detail;

    @NotNull
    @NotEmpty
    private int category;

    @NotNull
    @NotEmpty
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

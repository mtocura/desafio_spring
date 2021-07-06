package br.com.bootcamp.desafio_spring.form;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PostForm {
    @NotNull
    @NotEmpty
    private int userId;

    @NotNull
    @NotEmpty
    @JsonProperty("id_post")
    private int postId;

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

    public PostForm(int userId, int postId, Date date, ProductForm detail, int category, double price) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public int getPostId() {
        return postId;
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

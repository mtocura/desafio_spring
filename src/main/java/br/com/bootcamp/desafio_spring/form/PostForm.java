package br.com.bootcamp.desafio_spring.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.*;
import java.time.ZonedDateTime;

public class PostForm {
    @NotNull(message = "O id do usuário não pode ser nulo")
    @Positive(message = "O id do usuário deve ser maior do que 0")
    private int userId;

    @NotNull(message = "O id da publicação não pode ser nulo")
    @Positive(message = "O id da publicação deve ser maior do que 0")
    @JsonProperty("id_post")
    private int postId;

    @NotNull(message = "A data da publicação não pode ser vazio ou nulo")
    @PastOrPresent(message = "A data da publicação deve ser datas passadas ou o dia de hoje")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private ZonedDateTime date;

    @NotNull(message = "Os detalhes do produto não podem ser nulos")
    private ProductForm detail;

    @NotNull(message = "A categoria não pode ser nula")
    @Positive(message = "A categoria deve ser maior do que 0")
    private int category;

    @NotNull(message = "O preço não pode ser nula")
    @Positive(message = "O preço deve ser maior do que 0")
    private double price;

    public PostForm() {
    }

    public PostForm(int userId, int postId, ZonedDateTime date, ProductForm detail, int category, double price) {
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

    public ZonedDateTime getDate() {
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

package br.com.bootcamp.desafio_spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class PostDTO {
    @JsonProperty("id_post")
    private Integer postID;
    private ZonedDateTime date;
    private ProductDTO detail;
    private Integer category;
    private Double price;

    public PostDTO(Integer postID, ZonedDateTime date, ProductDTO detail, Integer category, Double price) {
        this.postID = postID;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public Integer getPostID() {
        return postID;
    }

    public void setPostID(Integer postID) {
        this.postID = postID;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public ProductDTO getDetail() {
        return detail;
    }

    public void setDetail(ProductDTO detail) {
        this.detail = detail;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

package br.com.bootcamp.desafio_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Post implements IEntity {
    private Integer ID;
    private Double price;
    private Integer category;
    private Product product;
    private Integer sellerID;
    private Boolean hasPromo;
    private Double discount;
    private Date expireAt;
    private Date createdAt;

    public Post() {
    }

    public Post(Integer ID, Double price, Integer category, Product product, Integer sellerID, Boolean hasPromo, Double discount, Date expireAt, Date createdAt) {
        this.ID = ID;
        this.price = price;
        this.category = category;
        this.product = product;
        this.sellerID = sellerID;
        this.hasPromo = hasPromo;
        this.discount = discount;
        this.expireAt = expireAt;
        this.createdAt = createdAt;
    }

    @Override
    public Integer getID() {
        return ID;
    }

    @Override
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getSellerID() {
        return sellerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    public Boolean getHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(Boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(Date expireAt) {
        this.expireAt = expireAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

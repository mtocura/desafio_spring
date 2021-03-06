package br.com.bootcamp.desafio_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Post implements IEntity, Comparable<Post> {
    private Integer id;
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

    public Post(Integer id, Double price, Integer category, Product product, Integer sellerID, Boolean hasPromo, Double discount, Date expireAt, Date createdAt) {
        this.id = id;
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
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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


    @Override
    public int compareTo(Post post) {
        Date postDate = post.getCreatedAt();
        if (postDate.before(this.getCreatedAt())) {
            return -1;
        }
        if (postDate.after(this.getCreatedAt())) {
            return 1;
        }
        return 0;
    }
}

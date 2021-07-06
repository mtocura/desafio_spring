package br.com.bootcamp.desafio_spring.dto;

import java.util.Date;

public class PostDTO {
    private Integer userId;
    private Integer id;
    private Double price;
    private Integer category;
    private ProductDTO productDTO;
    private Integer sellerID;
    private Boolean hasPromo;
    private Double discount;
    private Date expiredAt;
    private Date createdAt;

    public PostDTO(Integer userId, Integer id, Double price, Integer category, ProductDTO productDTO, Integer sellerID, Boolean hasPromo, Double discount, Date expiredAt, Date createdAt) {
        this.userId = userId;
        this.id = id;
        this.price = price;
        this.category = category;
        this.productDTO = productDTO;
        this.sellerID = sellerID;
        this.hasPromo = hasPromo;
        this.discount = discount;
        this.expiredAt = expiredAt;
        this.createdAt = createdAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

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

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
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

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

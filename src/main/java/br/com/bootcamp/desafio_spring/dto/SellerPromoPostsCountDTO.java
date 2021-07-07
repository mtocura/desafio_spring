package br.com.bootcamp.desafio_spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SellerPromoPostsCountDTO {

    private Integer userId;
    private String userName;
    @JsonProperty("promoproducts_count")
    private Integer promoProductsCount;

    public SellerPromoPostsCountDTO(Integer userId, String userName, Integer promoProductsCount) {
        this.userId = userId;
        this.userName = userName;
        this.promoProductsCount = promoProductsCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPromoProductsCount() {
        return promoProductsCount;
    }

    public void setPromoProductsCount(Integer promoProductsCount) {
        this.promoProductsCount = promoProductsCount;
    }
}

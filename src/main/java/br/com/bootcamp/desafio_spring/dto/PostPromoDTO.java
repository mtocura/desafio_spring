package br.com.bootcamp.desafio_spring.dto;

import java.util.List;

public class PostPromoDTO {
    private Integer userId;
    private String userName;
    private Integer promoProductsCount;
    private List<PostDTO> promoPosts;

    public PostPromoDTO(Integer userId, String userName, Integer promoProductsCount) {
        this.userId = userId;
        this.userName = userName;
        this.promoProductsCount = promoProductsCount;
    }

    public PostPromoDTO(Integer userId, String userName, List<PostDTO> promoPosts) {
        this.userId = userId;
        this.userName = userName;
        this.promoPosts = promoPosts;
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

    public List<PostDTO> getPromoPosts() {
        return promoPosts;
    }

    public void setPromoPosts(List<PostDTO> promoPosts) {
        this.promoPosts = promoPosts;
    }
}

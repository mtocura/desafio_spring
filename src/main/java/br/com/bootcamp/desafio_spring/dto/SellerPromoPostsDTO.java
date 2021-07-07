package br.com.bootcamp.desafio_spring.dto;

import java.util.List;

public class SellerPromoPostsDTO {

    private Integer userId;
    private String userName;
    private List<PostPromoDTO> posts;

    public SellerPromoPostsDTO(Integer userId, String userName, List<PostPromoDTO> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
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

    public List<PostPromoDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostPromoDTO> posts) {
        this.posts = posts;
    }
}

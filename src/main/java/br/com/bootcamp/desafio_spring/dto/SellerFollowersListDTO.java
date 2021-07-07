package br.com.bootcamp.desafio_spring.dto;

import java.util.List;

public class SellerFollowersDTO {

    private Integer userId;
    private String userName;
    private List<UserDefaultDTO> followers;

    public SellerFollowersDTO(Integer userId, String userName, List<UserDefaultDTO> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
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

    public List<UserDefaultDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDefaultDTO> followers) {
        this.followers = followers;
    }
}

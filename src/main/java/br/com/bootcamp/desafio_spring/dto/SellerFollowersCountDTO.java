package br.com.bootcamp.desafio_spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SellerFollowersCountDTO {

    private Integer userId;
    private String userName;
    @JsonProperty("followers_count")
    private Integer followersCount;

    public SellerFollowersCountDTO(Integer userId, String userName, Integer followersCount) {
        this.userId = userId;
        this.userName = userName;
        this.followersCount = followersCount;
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

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }
}

package br.com.bootcamp.desafio_spring.dto;

import java.util.List;

public class SellerDTO {
    private Integer id;
    private String name;
    private List<UserDTO> followers;
    private Integer followersCount;

    public SellerDTO(Integer id, String name, List<UserDTO> followers) {
        this.id = id;
        this.name = name;
        this.followers = followers;
    }

    public SellerDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public SellerDTO(Integer id, String name, Integer followersCount) {
        this.id = id;
        this.name = name;
        this.followersCount = followersCount;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDTO> followers) {
        this.followers = followers;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }
}

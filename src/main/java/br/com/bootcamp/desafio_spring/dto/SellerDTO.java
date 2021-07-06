package br.com.bootcamp.desafio_spring.dto;

import java.util.List;

public class SellerFollowersListDTO {
    private Integer id;
    private String userName;
    private List<UserDTO> followers;

    public SellerFollowersListDTO(Integer id, String userName, List<UserDTO> followers) {
        this.id = id;
        this.userName = userName;
        this.followers = followers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDTO> followers) {
        this.followers = followers;
    }
}

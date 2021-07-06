package br.com.bootcamp.desafio_spring.dto;

import java.util.List;

public class SellerDTO {
    private Integer id;
    private String userName;
    private List<UserDTO> followers;
    private List<PostDTO> postDTOs;

    public SellerDTO() {
    }

    public SellerDTO(Integer id, String userName, List<UserDTO> followers, List<PostDTO> postDTOs) {
        this.id = id;
        this.userName = userName;
        this.followers = followers;
        this.postDTOs = postDTOs;
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

    public List<PostDTO> getPostDTOS() {
        return postDTOS;
    }

    public void setPostDTOS(List<PostDTO> postDTOS) {
        this.postDTOS = postDTOS;
    }
}

package br.com.bootcamp.desafio_spring.dto;

import java.util.List;

public class UserDTO {
    private Integer id;
    private String name;
    private List<SellerDTO> following;


    public UserDTO(Integer id, String name, List<SellerDTO> following) {
        this.id = id;
        this.name = name;
        this.following = following;
    }

    public UserDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public List<SellerDTO> getFollowing() {
        return following;
    }

    public void setFollowing(List<SellerDTO> following) {
        this.following = following;
    }
}

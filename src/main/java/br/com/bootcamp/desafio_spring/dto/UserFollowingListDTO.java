package br.com.bootcamp.desafio_spring.dto;

import java.util.List;

public class UserFollowingListDTO {

    private Integer userId;
    private String userName;
    private List<UserDefaultDTO> followed;

    public UserFollowingListDTO(Integer userId, String userName, List<UserDefaultDTO> followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed = followed;
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

    public List<UserDefaultDTO> getFollowed() {
        return followed;
    }

    public void setFollowed(List<UserDefaultDTO> followed) {
        this.followed = followed;
    }
}

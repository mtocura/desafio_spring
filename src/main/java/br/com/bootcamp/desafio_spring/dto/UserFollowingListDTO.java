package br.com.bootcamp.desafio_spring.dto;

import java.util.List;

public class UserFollowingListDTO {

    private Integer userID;
    private String userName;
    private List<UserDefaultDTO> followed;

    public UserFollowingListDTO(Integer userID, String userName, List<UserDefaultDTO> followed) {
        this.userID = userID;
        this.userName = userName;
        this.followed = followed;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

package br.com.bootcamp.desafio_spring.entity;

public class UserFollow {
    private Integer user;
    private Integer seller;

    public UserFollow() {
    }

    public UserFollow(Integer user, Integer seller) {
        this.user = user;
        this.seller = seller;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public Integer getSeller() {
        return seller;
    }

    public void setSeller(Integer seller) {
        this.seller = seller;
    }
}

package br.com.bootcamp.desafio_spring.entity;

import java.util.List;

public class User implements IEntity {
    private Integer ID;
    private String name;
    private List<Seller> following;

    public User() {
    }

    public User(Integer ID, String name, List<Seller> following) {
        this.ID = ID;
        this.name = name;
        this.following = following;
    }

    @Override
    public Integer getID() {
        return ID;
    }

    @Override
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seller> getFollowing() {
        return following;
    }

    public void setFollowing(List<Seller> following) {
        this.following = following;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", following=" + following +
                '}';
    }

}

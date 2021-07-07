package br.com.bootcamp.desafio_spring.entity;

import java.util.List;

public class User implements IEntity {
    private Integer ID;
    private String name;
    private boolean isSeller;
    private List<Post> posts;

    public User() {
    }

    public User(Integer ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public User(Integer ID, String name, boolean isSeller) {
        this.ID = ID;
        this.name = name;
        this.isSeller = isSeller;
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

    public boolean isSeller() {
        return isSeller;
    }

    public void setSeller(boolean seller) {
        isSeller = seller;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }

}

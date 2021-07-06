package br.com.bootcamp.desafio_spring.entity;

import java.util.List;

public class Seller implements IEntity{
    private Integer ID;
    private String userName;
    private List<User> followers;
    private List<Post> posts;

    public Seller() {
    }

    public Seller(Integer ID, String userName, List<User> followers, List<Post> posts) {
        this.ID = ID;
        this.userName = userName;
        this.followers = followers;
        this.posts = posts;
    }

    @Override
    public Integer getID() {
        return ID;
    }

    @Override
    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

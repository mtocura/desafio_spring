package br.com.bootcamp.desafio_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements IEntity {
    private Integer id;
    private String name;
    private boolean isSeller;
    private List<Post> posts;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(Integer id, String name, boolean isSeller) {
        this.id = id;
        this.name = name;
        this.isSeller = isSeller;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(boolean seller) {
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
                "ID=" + id +
                ", name='" + name + '\'' +
                ", isSeller=" + isSeller +
                ", posts=" + posts +
                '}';
    }
}

package br.com.bootcamp.desafio_spring.storage;

import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.entity.Product;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.entity.UserFollow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class State {

    private Map<Integer, Post> posts;
    private Map<Integer, Product> products;
    private Map<Integer, User> users;
    private List<UserFollow> userFollows;

    public State() {
    }

    public Map<Integer, Post> getPosts() {
        if (posts == null) {
            posts = new HashMap<>();
        }
        return posts;
    }

    public void setPosts(Map<Integer, Post> posts) {
        this.posts = posts;
    }

    public Map<Integer, Product> getProducts() {
        if (products == null) {
            products = new HashMap<>();
        }
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public Map<Integer, User> getUsers() {
        if (users == null) {
            users = new HashMap<>();
        }
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }

    public List<UserFollow> getUserFollows() {
        if (userFollows == null) {
            userFollows = new ArrayList<>();
        }
        return userFollows;
    }

    public void setUserFollows(List<UserFollow> userFollows) {
        this.userFollows = userFollows;
    }

    @Override
    public String toString() {
        return "State{" +
                "posts=" + posts +
                ", products=" + products +
                ", userFollows=" + userFollows +
                ", users=" + users +
                '}';
    }
}

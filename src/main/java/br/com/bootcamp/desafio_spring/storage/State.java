package br.com.bootcamp.desafio_spring.storage;

import br.com.bootcamp.desafio_spring.entity.Post;
import br.com.bootcamp.desafio_spring.entity.Product;
import br.com.bootcamp.desafio_spring.entity.Seller;
import br.com.bootcamp.desafio_spring.entity.User;

import java.util.HashMap;
import java.util.Map;

public class State {

    private Map<Integer, Post> posts;
    private Map<Integer, Product> products;
    private Map<Integer, Seller> sellers;
    private Map<Integer, User> users;

    public State() {
        this.posts = new HashMap<>();
        this.products = new HashMap<>();
        this.sellers = new HashMap<>();
        this.users = new HashMap<>();
    }

    public Map<Integer, Post> getPosts() {
        return posts;
    }

    public void setPosts(Map<Integer, Post> posts) {
        this.posts = posts;
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public Map<Integer, Seller> getSellers() {
        return sellers;
    }

    public void setSellers(Map<Integer, Seller> sellers) {
        this.sellers = sellers;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public void setUsers(Map<Integer, User> users) {
        this.users = users;
    }


    @Override
    public String toString() {
        return "State{" +
                "posts=" + posts +
                ", products=" + products +
                ", sellers=" + sellers +
                ", users=" + users +
                '}';
    }
}

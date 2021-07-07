package br.com.bootcamp.desafio_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFollow implements IEntity {
    private Integer id;
    private Integer user;
    private Integer seller;

    public UserFollow() {
    }

    public UserFollow(Integer id) {
        this.id = id;
    }

    public UserFollow(Integer user, Integer seller) {
        this.user = user;
        this.seller = seller;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserFollow b = (UserFollow) obj;
        return this.id == b.id || (this.user == b.user && this.seller == b.seller);
    }
}

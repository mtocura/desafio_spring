package br.com.bootcamp.desafio_spring.entity;

public class UserFollow implements IEntity {
    private Integer ID;
    private Integer user;
    private Integer seller;

    public UserFollow() {
    }

    public UserFollow(Integer ID) {
        this.ID = ID;
    }

    public UserFollow(Integer user, Integer seller) {
        this.user = user;
        this.seller = seller;
    }

    @Override
    public Integer getID() {
        return ID;
    }

    @Override
    public void setID(Integer ID) {
        this.ID = ID;
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
        return this.ID == b.ID || (this.user == b.user && this.seller == b.seller);
    }
}

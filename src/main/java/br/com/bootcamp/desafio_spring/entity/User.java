package br.com.bootcamp.desafio_spring.entity;

public class User implements IEntity {
    private Integer ID;
    private String name;

    public User() {
    }

    public User(Integer ID, String name) {
        this.ID = ID;
        this.name = name;
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

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }

}

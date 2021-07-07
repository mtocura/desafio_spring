package br.com.bootcamp.desafio_spring.entity;

public class Product implements IEntity {
    private Integer ID;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public Product(Integer ID, String name, String type, String brand, String color, String notes) {
        this.ID = ID;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

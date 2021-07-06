package br.com.bootcamp.desafio_spring.form;

public class ProductForm {
    private int product_id;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public ProductForm() {
    }

    public ProductForm(int product_id, String productName, String type, String brand, String color, String notes) {
        this.product_id = product_id;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getProductName() {
        return productName;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getNotes() {
        return notes;
    }
}

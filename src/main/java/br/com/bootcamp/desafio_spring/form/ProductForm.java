package br.com.bootcamp.desafio_spring.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductForm {
    @NotNull
    @NotEmpty
    private int product_id;

    @NotNull
    @NotEmpty
    private String productName;

    @NotNull
    @NotEmpty
    private String type;

    @NotNull
    @NotEmpty
    private String brand;

    @NotNull
    @NotEmpty
    private String color;

    @NotNull
    @NotEmpty
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

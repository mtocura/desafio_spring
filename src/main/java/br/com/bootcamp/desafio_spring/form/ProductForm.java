package br.com.bootcamp.desafio_spring.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductForm {
    @NotNull
    @NotEmpty
    private int productId;

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

    public ProductForm(int productId, String productName, String type, String brand, String color, String notes) {
        this.productId = ProductForm.this.productId;
        this.productName = productName;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public int getProductId() {
        return productId;
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

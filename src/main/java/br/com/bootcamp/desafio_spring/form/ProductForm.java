package br.com.bootcamp.desafio_spring.form;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProductForm {
    @NotNull(message = "É necessário passar o id do produto")
    @Positive(message = "Id do produto deve ser > 0")
    @JsonProperty("product_id")
    private int productId;

    @NotEmpty(message = "O nome do produto não pode ser vazio ou nulo")
    @NotBlank(message = "O nome do produto não pode ser espaços em branco ou nulo")
    private String productName;

    @NotEmpty(message = "O tipo do produto não pode ser vazio ou nulo")
    @NotBlank(message = "O tipo do produto não pode ser espaços em branco ou nulo")
    private String type;

    @NotEmpty(message = "A marca do produto não pode ser vazio ou nulo")
    @NotBlank(message = "A marca do produto não pode ser espaços em branco ou nulo")
    private String brand;

    @NotEmpty(message = "A cor do produto não pode ser vazio ou nulo")
    @NotBlank(message = "A cor do produto não pode ser espaços em branco ou nulo")
    private String color;

    @NotEmpty(message = "O comentário do produto não pode ser vazio ou nulo")
    @NotBlank(message = "O comentário do produto não pode ser espaços em branco ou nulo")
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

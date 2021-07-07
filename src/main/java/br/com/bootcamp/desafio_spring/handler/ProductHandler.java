package br.com.bootcamp.desafio_spring.handler;

import br.com.bootcamp.desafio_spring.dto.ProductDTO;
import br.com.bootcamp.desafio_spring.entity.Product;
import br.com.bootcamp.desafio_spring.form.ProductForm;

import java.io.IOException;
import java.util.Map;

public class ProductHandler {

    public static Product create(ProductForm productForm) {
        return new Product(
                productForm.getProductId(),
                productForm.getProductName(),
                productForm.getType(),
                productForm.getBrand(),
                productForm.getColor(),
                productForm.getNotes()
        );
    }

    public Map<String, String> validate(ProductForm productForm) {
        return null;
    }

    public static ProductDTO convert(Product product) {
        return new ProductDTO(
                product.getID(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }
}

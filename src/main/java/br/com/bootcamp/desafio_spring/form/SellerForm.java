package br.com.bootcamp.desafio_spring.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SellerForm {
    @NotNull
    @NotEmpty
    private String name;

    public SellerForm() {
    }

    public SellerForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

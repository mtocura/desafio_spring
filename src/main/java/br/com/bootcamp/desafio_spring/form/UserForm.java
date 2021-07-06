package br.com.bootcamp.desafio_spring.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserForm {
    @NotNull
    @NotEmpty
    private String name;

    public UserForm() {
    }

    public UserForm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

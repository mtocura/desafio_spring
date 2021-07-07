package br.com.bootcamp.desafio_spring.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserForm {
    @NotEmpty(message = "O nome do usuário não pode ser vazio ou nulo")
    @NotBlank(message = "O nome do usuário não pode ser espaços em branco ou nulo")
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

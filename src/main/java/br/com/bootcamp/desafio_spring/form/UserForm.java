package br.com.bootcamp.desafio_spring.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserForm {
    @NotEmpty(message = "O nome do usuário não pode ser vazio ou nulo")
    @NotBlank(message = "O nome do usuário não pode ser espaços em branco ou nulo")
    private String name;

    @NotNull(message = "O atributo que identifica se um usuário é vendedor não pode ser nulo")
    private boolean isSeller;

    public UserForm() {
    }

    public UserForm(String name, boolean isSeller) {
        this.name = name;
        this.isSeller = isSeller;
    }

    public String getName() {
        return name;
    }

    public boolean getIsSeller() {
        return isSeller;
    }
}

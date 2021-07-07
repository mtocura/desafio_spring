package br.com.bootcamp.desafio_spring.handler;

import br.com.bootcamp.desafio_spring.dto.UserDefaultDTO;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.form.PostForm;
import br.com.bootcamp.desafio_spring.form.UserForm;

import java.util.Map;

public class UserHandler {

    public static User create(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setSeller(userForm.getIsSeller());

        return user;
    }

    public Map<String, String> validate(UserForm userForm) {
        return null;
    }

    public static UserDefaultDTO convert(User user) {
        return new UserDefaultDTO(user.getID(), user.getName());
    }

}

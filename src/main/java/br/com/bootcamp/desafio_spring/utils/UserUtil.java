package br.com.bootcamp.desafio_spring.utils;

import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.exception.UserNotExistException;

public final class UserUtil {
    private UserUtil() {}

    public static void userExists(User user, int id) {
        if (user == null) {
            throw new UserNotExistException("Vendedor " + id + " não encontrado.");
        }
    }

    public static void userIsSeller(User user, int id) {
        userExists(user, id);
        if (!user.getIsSeller()) {
            throw new UserNotExistException("Usuário " + id + " não é vendedor.");
        }
    }
}

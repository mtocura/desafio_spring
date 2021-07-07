package br.com.bootcamp.desafio_spring.handler;

import br.com.bootcamp.desafio_spring.dto.SellerFollowersListDTO;
import br.com.bootcamp.desafio_spring.dto.UserDefaultDTO;
import br.com.bootcamp.desafio_spring.dto.UserFollowingListDTO;
import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.form.UserForm;

import java.util.ArrayList;
import java.util.List;

public class UserHandler {

    public static User create(UserForm userForm) {
        User user = new User();
        user.setName(userForm.getName());
        user.setIsSeller(userForm.getIsSeller());

        return user;
    }

    public static UserDefaultDTO convert(User user) {
        return new UserDefaultDTO(user.getId(), user.getName());
    }

    // Método para converter a lista de todos os usuários que o usuário selecionado para DTOs
    public static UserFollowingListDTO convertFollowingUsers(Integer userID, String userName, List<User> userList) {
        List<UserDefaultDTO> userDefaultDTOList = new ArrayList<>();
        for (User user: userList) {
            userDefaultDTOList.add(UserHandler.convert(user));
        }
        return new UserFollowingListDTO(userID, userName, userDefaultDTOList);
    }

    // Método para converter a lista de todos os seguidores de um usuário para DTOs
    public static SellerFollowersListDTO convertSellerFollowers(Integer userID, String userName, List<User> userList) {
        List<UserDefaultDTO> userDefaultDTOList = new ArrayList<>();
        for (User user: userList) {
            userDefaultDTOList.add(UserHandler.convert(user));
        }
        return new SellerFollowersListDTO(userID, userName, userDefaultDTOList);
    }
}

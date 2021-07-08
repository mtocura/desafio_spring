package br.com.bootcamp.desafio_spring.utils;

import br.com.bootcamp.desafio_spring.entity.User;
import br.com.bootcamp.desafio_spring.entity.UserFollow;
import br.com.bootcamp.desafio_spring.repository.UserFollowRepository;
import br.com.bootcamp.desafio_spring.repository.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class RepositoryUtil {
    private RepositoryUtil() {}

    public static List<User> getFollowedSellers(int userId, UserRepository userRep, UserFollowRepository followRepo) throws IOException {
        List<UserFollow> follows = followRepo.getUserFollowed(userId);
        List<User> sellers = new ArrayList<>();

        for (UserFollow f : follows) {
            User userFollower = userRep.getById(f.getSeller());
            sellers.add(userFollower);
        }
        return sellers;
    }

    public static List<User> getSellerFollowers(int sellerId, UserRepository userRep, UserFollowRepository followRepo) throws IOException {
        List<UserFollow> follows = followRepo.getSellerFollowers(sellerId);
        List<User> followers = new ArrayList<>();

        for (UserFollow f : follows) {
            User follower = userRep.getById(f.getUser());
            followers.add(follower);
        }
        return followers;
    }
}

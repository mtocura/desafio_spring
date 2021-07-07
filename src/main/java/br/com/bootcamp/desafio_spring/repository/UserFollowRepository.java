package br.com.bootcamp.desafio_spring.repository;

import br.com.bootcamp.desafio_spring.entity.UserFollow;
import br.com.bootcamp.desafio_spring.storage.State;
import br.com.bootcamp.desafio_spring.storage.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Repository
public class UserFollowRepository extends Repository<UserFollow> {

    public UserFollow get(int userId, int sellerId) throws IOException {
        List<UserFollow> state = Storage.getInstance().load().getUserFollows();
        for (UserFollow uf : state) {
            if (uf.getUser() == userId && uf.getSeller() == sellerId) {
                return uf;
            }
        }
        return null;
    }

    public List<UserFollow> getUserFollowed(int userId) throws IOException {
        List<UserFollow> state = Storage.getInstance().load().getUserFollows();
        List<UserFollow> res = new ArrayList<>();

        for (UserFollow uf : state) {
            if (uf.getUser() == userId) {
                res.add(uf);
            }
        }
        return res;
    }

    public List<UserFollow> getSellerFollowers(int sellerId) throws IOException {
        List<UserFollow> state = Storage.getInstance().load().getUserFollows();
        List<UserFollow> res = new ArrayList<>();

        for (UserFollow uf : state) {
            if (uf.getSeller() == sellerId) {
                res.add(uf);
            }
        }
        return res;
    }

    public void remove(int userId, int sellerId) throws IOException {
        this.remove(new UserFollow(userId, sellerId));
    }

    public void remove(UserFollow r) throws IOException {
        List<UserFollow> state = Storage.getInstance().load().getUserFollows();
        state.remove(r);
    }

    @Override
    public UserFollow getById(int id) throws IOException {
        throw new IOException("Operação inválida neste repositório");
    }

    @Override
    public List<UserFollow> getById(List<Integer> ids) throws IOException {
        List<UserFollow> state = Storage.getInstance().load().getUserFollows();
        List<UserFollow> res = new ArrayList<>();
        for (UserFollow uf : state) {
            if (ids.contains(uf.getId())) {
                res.add(uf);
            }
        }
        return res;
    }

    @Override
    public List<UserFollow> getAll() throws IOException {
        return Storage.getInstance().load().getUserFollows();
    }

    @Override
    public int save(UserFollow p) throws IOException {
        State s = Storage.getInstance().load();
        List<UserFollow> state = s.getUserFollows();

        int id = this.generatesNextId(s);

        for (UserFollow uf : state) {
            if (uf.equals(p)) {
                throw new IOException("Este relacionamento já existe");
            }
        }

        p.setId(id);
        state.add(p);
        Storage.getInstance().flush();
        return id;
    }

    @Override
    public int update(UserFollow p) throws IOException {
        State s = Storage.getInstance().load();
        List<UserFollow> state = s.getUserFollows();
        int id = this.generatesNextId(s);

        for (UserFollow uf : state) {
            if (uf.equals(p)) {
                uf.setUser(p.getUser());
                uf.setSeller(p.getSeller());
                Storage.getInstance().flush();
            }
        }

        return this.save(p);
    }

    @Override
    public void remove(int id) throws IOException {
        List<UserFollow> state = Storage.getInstance().load().getUserFollows();
        state.remove(new UserFollow(id));
    }

    @Override
    protected Map<Integer, UserFollow> getState(State s) {
        return null;
    }

    @Override
    protected int generatesNextId(State s) {
        return s.getNextUserFollowId();
    }
}

package br.com.bootcamp.desafio_spring.repository;

import br.com.bootcamp.desafio_spring.entity.IEntity;
import br.com.bootcamp.desafio_spring.storage.State;
import br.com.bootcamp.desafio_spring.storage.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Respository<T extends IEntity> {
    private int nextID;

    public T getById(int id) throws IOException {
        State s = Storage.getInstance().load();
        Map<Integer, T> entities = this.getState(s);
        return entities.get(id);
    }

    public List<T> getById(List<Integer> ids) throws IOException {
        State s = Storage.getInstance().load();
        Map<Integer, T> entities = this.getState(s);
        List<T> res = new ArrayList<>();
        for (int id : ids) {
            res.add(entities.get(id));
        }
        return res;
    }

    public List<T> getAll() throws IOException {
        State s = Storage.getInstance().load();
        Map<Integer, T> entities = this.getState(s);
        return new ArrayList<>(entities.values());
    }

    public int save(T p) throws IOException {
        State s = Storage.getInstance().load();
        Map<Integer, T> entities = this.getState(s);

        int id = nextID++;
        p.setId(id);

        entities.put(id, p);
        Storage.getInstance().flush();
        return id;
    }

    public int update(T p) throws IOException {
        State s = Storage.getInstance().load();
        Map<Integer, T> entities = this.getState(s);

        entities.put(p.getId(), p);
        Storage.getInstance().flush();
        return p.getId();
    }

    public void remove(int id) throws IOException {
        State s = Storage.getInstance().load();
        Map<Integer, T> entities = this.getState(s);
        entities.remove(id);
        Storage.getInstance().flush();
    }

    protected abstract Map<Integer, T> getState(State s);
}

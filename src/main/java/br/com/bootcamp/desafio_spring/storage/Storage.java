package br.com.bootcamp.desafio_spring.storage;

import java.io.IOException;

public class Storage {

    private static Storage instance = new Storage();

    private IStorage storage = new FileStorage();

    private Storage() {}

    public State load() throws IOException {
        return this.storage.load();
    }

    public void flush() throws IOException {
        this.storage.flush();
    }

    public static Storage getInstance() {
        return instance;
    }
}

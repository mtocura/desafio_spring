package br.com.bootcamp.desafio_spring.storage;

import java.io.IOException;

public class MemoryStorage implements IStorage{

    private State state = new State();

    @Override
    public State load() throws IOException {
        return this.state;
    }

    @Override
    public void flush() throws IOException {
        // não faz nada
    }
}

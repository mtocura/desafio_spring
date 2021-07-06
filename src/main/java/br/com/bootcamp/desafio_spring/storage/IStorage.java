package br.com.bootcamp.desafio_spring.storage;

import java.io.IOException;

public interface IStorage {
    State load() throws IOException;
    void flush() throws IOException;

}

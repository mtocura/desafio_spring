package br.com.bootcamp.desafio_spring.handler;

import java.io.IOException;
import java.util.Map;

public interface IFormHandler<T, U> {
    T create(U o) throws IOException;

    Map<String, String> validate(U o);
}

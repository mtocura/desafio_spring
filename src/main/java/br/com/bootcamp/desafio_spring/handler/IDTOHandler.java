package br.com.bootcamp.desafio_spring.handler;

public interface IDTOHandler<T, U> {
    U convert(T o);
}

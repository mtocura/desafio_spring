package br.com.bootcamp.desafio_spring.controller;

import br.com.bootcamp.desafio_spring.exception.DatabaseException;
import br.com.bootcamp.desafio_spring.storage.State;
import br.com.bootcamp.desafio_spring.storage.Storage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class InspectionController {

    @GetMapping("/dev/inspect")
    public State inspect() {
        try {
            return Storage.getInstance().load();
        } catch (IOException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}

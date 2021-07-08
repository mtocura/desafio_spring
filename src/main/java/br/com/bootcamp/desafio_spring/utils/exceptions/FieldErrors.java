package br.com.bootcamp.desafio_spring.utils.exceptions;

import br.com.bootcamp.desafio_spring.dto.ExceptionFieldDTO;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class FieldErrors {

    // cria um ExceptionFieldDTO para cada atributo que viola alguma validação
    public static List<ExceptionFieldDTO> processFieldErrors(List<FieldError> fieldErrors) {
        List<ExceptionFieldDTO> exceptions = new ArrayList<>();
        for (FieldError fieldError: fieldErrors) {
            exceptions.add(new ExceptionFieldDTO(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return exceptions;
    }
}

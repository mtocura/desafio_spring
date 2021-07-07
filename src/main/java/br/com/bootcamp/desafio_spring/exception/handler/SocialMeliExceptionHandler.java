package br.com.bootcamp.desafio_spring.exception.handler;

import br.com.bootcamp.desafio_spring.exception.UserNotExistException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class SocialMeliExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentNotValidHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();

        List<FieldError> fieldErrors = e.getFieldErrors();
        List<ExceptionDTO> exceptions = processFieldErrors(fieldErrors);

        return ResponseEntity.badRequest().body(exceptions);
    }

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<?> userNotExistHandler(UserNotExistException e) {
        return ResponseEntity.badRequest().body(new ExceptioDTO(e.getMessage()));
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<?> userNotExistHandler(IOException e) {
        return ResponseEntity.badRequest().body(new ExceptioDTO(e.getMessage()));
    }

    // cria um ExceptionDTO para cada atributo que viola alguma validação
    private List<ExceptionDTO> processFieldErrors(List<FieldError> fieldErrors) {
        List<ExceptionDTO> exceptions = new ArrayList<>();
        for (FieldError fieldError: fieldErrors) {
            exceptions.add(new ExceptionDTO(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return exceptions;
    }
}

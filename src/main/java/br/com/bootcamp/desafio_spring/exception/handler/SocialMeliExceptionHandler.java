package br.com.bootcamp.desafio_spring.exception.handler;

import br.com.bootcamp.desafio_spring.dto.ExceptionDTO;
import br.com.bootcamp.desafio_spring.dto.ExceptionFieldDTO;
import br.com.bootcamp.desafio_spring.exception.SellerIsNotFollowedException;
import br.com.bootcamp.desafio_spring.exception.DatabaseException;
import br.com.bootcamp.desafio_spring.exception.InvalidFollowException;
import br.com.bootcamp.desafio_spring.exception.UserIsNotSellerException;
import br.com.bootcamp.desafio_spring.exception.UserNotExistException;
import br.com.bootcamp.desafio_spring.utils.exceptions.FieldErrors;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class SocialMeliExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentNotValidHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();

        List<FieldError> fieldErrors = result.getFieldErrors();
        ExceptionFieldDTO exceptions = FieldErrors.processFieldErrors(fieldErrors);

        return ResponseEntity.badRequest().body(exceptions);
    }

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<?> userNotExistHandler(UserNotExistException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<?> userNotExistHandler(DatabaseException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(UserIsNotSellerException.class)
    public ResponseEntity<?> userIsNotSellerHandler(UserIsNotSellerException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(InvalidFollowException.class)
    public ResponseEntity<?> invalidFollowHandler(InvalidFollowException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }

    @ExceptionHandler(SellerIsNotFollowedException.class)
    public ResponseEntity<?> sellerIsNotFollowedHandler(SellerIsNotFollowedException e) {
        return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
    }
}

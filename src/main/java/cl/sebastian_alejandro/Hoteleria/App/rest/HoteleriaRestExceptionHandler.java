package cl.sebastian_alejandro.Hoteleria.App.rest;

import cl.sebastian_alejandro.Hoteleria.App.commons.HoteleriaErrorResponse;
import cl.sebastian_alejandro.Hoteleria.App.commons.HoteleriaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HoteleriaRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<HoteleriaErrorResponse> handlerException(HoteleriaNotFoundException exc) {

        HoteleriaErrorResponse error = new HoteleriaErrorResponse();

        error.setError(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<HoteleriaErrorResponse> handlerException(Exception exc) {
        HoteleriaErrorResponse error = new HoteleriaErrorResponse();

        error.setError(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

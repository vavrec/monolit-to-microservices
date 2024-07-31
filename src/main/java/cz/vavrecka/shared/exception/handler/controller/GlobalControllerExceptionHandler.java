package cz.vavrecka.shared.exception.handler.controller;


import cz.vavrecka.shared.exception.ObjectDoesNotExistsException;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = ObjectDoesNotExistsException.class)
    public ProblemDetail handleMyCustomException(ObjectDoesNotExistsException ex) {
        return ProblemDetail.forStatusAndDetail(NOT_FOUND, ex.getMessage());
    }
}

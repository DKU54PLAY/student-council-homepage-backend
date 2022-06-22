package dankook.play.studentcouncilhomepage.application.controller;

import dankook.play.studentcouncilhomepage.application.exception.NotExistException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<String> handle(NotExistException e) {
        return ResponseEntity.notFound().build();
    }
}

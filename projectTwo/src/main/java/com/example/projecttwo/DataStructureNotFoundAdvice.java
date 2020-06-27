package com.example.projecttwo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class DataStructureNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(DataStructureNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(DataStructureNotFoundException ex) {
        return ex.getMessage();
    }
}

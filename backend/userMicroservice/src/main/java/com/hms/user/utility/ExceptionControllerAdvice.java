package com.hms.user.utility;

import com.hms.user.exception.HmsException;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @Autowired
    Environment environment;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> handleException(Exception e){
        ErrorInfo errorInfo = new ErrorInfo("Some error occurred!!!  ❌", HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

   @ExceptionHandler(HmsException.class)
   public ResponseEntity<ErrorInfo> handleHmsException(HmsException e){
       ErrorInfo errorInfo = new ErrorInfo(environment.getProperty(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now());
       return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
   }

    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorInfo> handleViolationException(Exception e){
        String errorMessage;
        if(e instanceof MethodArgumentNotValidException methodArgumentNotValidException){
            errorMessage = methodArgumentNotValidException.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
        } else {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
            errorMessage = constraintViolationException.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(","));
        }
        ErrorInfo errorInfo = new ErrorInfo(errorMessage, HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}

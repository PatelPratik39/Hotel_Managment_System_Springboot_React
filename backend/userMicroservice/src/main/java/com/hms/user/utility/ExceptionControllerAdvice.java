package com.hms.user.utility;

import com.hms.user.exception.HmsException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

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

}

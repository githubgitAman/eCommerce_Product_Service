package dev.aman.ecommerce_product_service.ControllerAdvice;

import dev.aman.ecommerce_product_service.DTOs.ExceptionDTOs;
import dev.aman.ecommerce_product_service.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionalHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ExceptionDTOs> handleNullPointerException(){
        ExceptionDTOs exceptionDTOs = new ExceptionDTOs();
        exceptionDTOs.setMessage("No Product Found, please enter a valid product Id");
        ResponseEntity<ExceptionDTOs> reponse = new ResponseEntity<>(
                exceptionDTOs
                , HttpStatus.NOT_FOUND
        );
        return reponse;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTOs> handleProductNotFoundException(){
        ExceptionDTOs exceptionDTOs = new ExceptionDTOs();
        exceptionDTOs.setMessage("Product Not Found, please enter a valid product Id");
        ResponseEntity<ExceptionDTOs> response = new ResponseEntity<>(
                exceptionDTOs,
                HttpStatus.NOT_FOUND
        );
        return response;
    }
}

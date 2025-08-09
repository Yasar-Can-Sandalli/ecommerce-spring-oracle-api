package com.sandalliyasarcan.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandling extends RuntimeException {

    //Spring Validation ile fırlatılan hataları yönetmek ve uygun response dönmek


    private List<String> addMapValue(List<String> list, String newValue){
        list.add(newValue);
        return list;
    }




    //Bu Anotasyon Dışarıdan MethodArgumentNotValidException tipinde bir hata fırlatılırsa o hatayı bu fonksiyon ile map ler ve parametre olarak geçirir
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){

        Map<String , List<String>> errorsMap = new HashMap<>();


        for (ObjectError objError : ex.getBindingResult().getAllErrors()) {
            String fieldName =  ((FieldError)objError).getField(); // objError u FieldError e cevirdik ve icindeki fieldName i aldik



            if (errorsMap.containsKey(fieldName)) {
                errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), ((FieldError)objError).getDefaultMessage()));
            }else{
                errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
            }


        }

        return ResponseEntity.badRequest().body(createApiError(errorsMap));

    }


    private <T> ApiError<T> createApiError(T errors){
        ApiError apiError = new ApiError();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrorsMap(errors);
        return apiError;

    }



}

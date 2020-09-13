package com.baskibond.seatbooking.exception;

import com.baskibond.seatbooking.models.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    private static final Logger LOGGER= LoggerFactory.getLogger(ExceptionHandler.class.getName());

    @org.springframework.web.bind.annotation.ExceptionHandler(BookingException.class)
    protected ResponseEntity handleRankedExceptin(BookingException ex) {
        LOGGER.info("BookingException is thrown");
        ResponseData responseData=new ResponseData(false,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),null);
        return new ResponseEntity(responseData,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UnauthorizedException.class)
    protected ResponseEntity handleUnauthorizedExceptin(UnauthorizedException ex) {
        LOGGER.info("Unauthorized Exception is thrown");
        ResponseData responseData=new ResponseData(false,ex.getMessage(), HttpStatus.UNAUTHORIZED.value(),null);
        return new ResponseEntity(responseData,HttpStatus.UNAUTHORIZED);

    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    protected ResponseEntity handleGenericExceptin(Exception ex) {
        LOGGER.info("Generic Exception is thrown");
        ResponseData responseData=new ResponseData(false,ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(),null);
        return new ResponseEntity(responseData,HttpStatus.INTERNAL_SERVER_ERROR);

    }

}

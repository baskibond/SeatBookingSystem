package com.baskibond.seatbooking.exception;

public class BookingException extends RuntimeException{

    public BookingException(String message){
        super(message);
    }

    public BookingException(){
    }
}

package com.baskibond.seatbooking.controller;


import com.baskibond.seatbooking.entities.Movie;
import com.baskibond.seatbooking.models.BookingRequest;
import com.baskibond.seatbooking.models.ResponseData;
import com.baskibond.seatbooking.services.BookingService;
import com.baskibond.seatbooking.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ResponseEntity<ResponseData> addMovie(
            @RequestBody BookingRequest bookingRequest
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,bookingService.performBooking(bookingRequest)));
    }
}

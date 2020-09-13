package com.baskibond.seatbooking.controller;

import com.baskibond.seatbooking.models.ResponseData;
import com.baskibond.seatbooking.services.PingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class PingController {

    @Autowired
    PingService pingService;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity<ResponseData>  ping(){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,pingService.pong(Optional.empty())));
    }
}

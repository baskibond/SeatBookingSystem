package com.baskibond.seatbooking.controller;

import com.baskibond.seatbooking.entities.Screening;
import com.baskibond.seatbooking.entities.Theatre;
import com.baskibond.seatbooking.models.ResponseData;
import com.baskibond.seatbooking.models.ScreenRequest;
import com.baskibond.seatbooking.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class TheatreController {

    @Autowired
    TheatreService theatreService;

    @RequestMapping(value = "/theatre", method = RequestMethod.POST)
    public ResponseEntity<ResponseData> addTheatre(
            @RequestBody Theatre theatre
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,theatreService.addTheatre(theatre)));
    }

    @RequestMapping(value = "/theatre/{theatre_id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseData> getTheatre(
            @PathVariable Integer theatre_id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,theatreService.getTheatre(theatre_id)));
    }

    @RequestMapping(value = "/screen", method = RequestMethod.POST)
    public ResponseEntity<ResponseData> addScreen(
            @RequestBody ScreenRequest screenRequest
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,theatreService.addScreen(screenRequest)));
    }

    @RequestMapping(value = "/screen/{screen_id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseData> getScreen(
            @PathVariable Integer screen_id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,theatreService.getScreen(screen_id)));
    }

    @RequestMapping(value = "/screen/{screen_id}/booked", method = RequestMethod.GET)
    public ResponseEntity<ResponseData> getBookedSeatList(
            @PathVariable Integer screen_id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,theatreService.getBookedList(screen_id)));
    }

    @RequestMapping(value = "/screen/{screen_id}/unbooked", method = RequestMethod.GET)
    public ResponseEntity<ResponseData> getUnBookedSeatList(
            @PathVariable Integer screen_id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,theatreService.getUnBookedList(screen_id)));
    }

    @RequestMapping(value = "/screen/{screen_id}/progress", method = RequestMethod.GET)
    public ResponseEntity<ResponseData> getLockedSeatList(
            @PathVariable Integer screen_id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,theatreService.getProgressedList(screen_id)));
    }
}

package com.baskibond.seatbooking.controller;

import com.baskibond.seatbooking.entities.Movie;
import com.baskibond.seatbooking.entities.Theatre;
import com.baskibond.seatbooking.models.ResponseData;
import com.baskibond.seatbooking.services.MovieService;
import com.baskibond.seatbooking.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class MoviesController {

    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/movie", method = RequestMethod.POST)
    public ResponseEntity<ResponseData> addMovie(
            @RequestBody Movie movie
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,movieService.addMovie(movie)));
    }

    @RequestMapping(value = "/movie/{movie_id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseData> getMovie(
            @PathVariable Integer movie_id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,movieService.getMovie(movie_id)));
    }
}

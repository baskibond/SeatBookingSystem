package com.baskibond.seatbooking.services;

import com.baskibond.seatbooking.entities.Movie;
import com.baskibond.seatbooking.repositories.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepo movieRepo;

    public Movie addMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    public Optional<Movie> getMovie(Integer movie_id) {
        return movieRepo.findById(movie_id);
    }
}

package com.baskibond.seatbooking.repositories;

import com.baskibond.seatbooking.entities.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie,  Integer> {
}

package com.baskibond.seatbooking.repositories;

import com.baskibond.seatbooking.entities.Theatre;
import org.springframework.data.repository.CrudRepository;

public interface TheatreRepo extends CrudRepository<Theatre, Integer> {
}

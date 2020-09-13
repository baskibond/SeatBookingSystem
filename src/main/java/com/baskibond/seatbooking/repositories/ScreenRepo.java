package com.baskibond.seatbooking.repositories;

import com.baskibond.seatbooking.entities.Screening;
import org.springframework.data.repository.CrudRepository;

public interface ScreenRepo extends CrudRepository<Screening,  Integer> {
}

package com.baskibond.seatbooking.repositories;

import com.baskibond.seatbooking.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}

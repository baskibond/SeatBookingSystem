package com.baskibond.seatbooking.services;

import com.baskibond.seatbooking.entities.User;
import com.baskibond.seatbooking.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public User addUser(User user){
        userRepo.save(user);
        return user;
    }

    public Optional<User> getUser(int user_id){
        return userRepo.findById(user_id);
    }
}

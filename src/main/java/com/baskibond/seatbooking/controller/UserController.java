package com.baskibond.seatbooking.controller;

import com.baskibond.seatbooking.entities.User;
import com.baskibond.seatbooking.models.ResponseData;
import com.baskibond.seatbooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<ResponseData> adduser(
            @RequestBody User user
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,userService.addUser(user)));
    }

    @RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseData> getUser(
            @PathVariable Integer user_id
    ){
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData(true,"",200,userService.getUser(user_id)));
    }
}

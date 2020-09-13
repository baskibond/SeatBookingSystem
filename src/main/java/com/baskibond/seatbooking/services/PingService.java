package com.baskibond.seatbooking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PingService {

    @Autowired
    Environment environment;

    public Map pong(Optional<String> echo){
        Map response=new HashMap();
        response.put("Ping","Pong");
        response.put("Time", Instant.now().getEpochSecond());
        response.put("Env",environment.getActiveProfiles()[0]);
        echo.ifPresent(x->response.put("Echo",x));

        return response;
    }
}

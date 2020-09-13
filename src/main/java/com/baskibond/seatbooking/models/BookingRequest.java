package com.baskibond.seatbooking.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequest {
    int screenId;
    int userId;
    List<Integer> seats;
}

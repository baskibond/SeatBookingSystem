package com.baskibond.seatbooking.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScreenRequest {
    int movieId;
    int theatreId;
}

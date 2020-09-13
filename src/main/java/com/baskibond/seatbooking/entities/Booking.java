package com.baskibond.seatbooking.entities;

import com.baskibond.seatbooking.models.PaymentStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    @OneToOne
    @JoinColumn(name="screen_id")
    private Screening screening;
    @OneToMany(targetEntity=Seat.class, fetch= FetchType.EAGER)
    List<Seat> seats;
    Date booked_on;
    @Enumerated(EnumType.STRING)
    PaymentStatus payment_status;
    String txn_id;



}

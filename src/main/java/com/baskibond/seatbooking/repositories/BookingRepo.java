package com.baskibond.seatbooking.repositories;

import com.baskibond.seatbooking.entities.Booking;
import com.baskibond.seatbooking.entities.Seat;
import com.baskibond.seatbooking.models.PaymentStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookingRepo  extends CrudRepository<Booking,  Integer> {

    @Query(value="select * from Booking where payment_status=?1", nativeQuery = true)
    List<Booking> findAllUnpaidAndLocked(String id);
}

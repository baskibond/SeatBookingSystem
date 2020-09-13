package com.baskibond.seatbooking.repositories;

import com.baskibond.seatbooking.entities.Seat;
import com.baskibond.seatbooking.entities.Theatre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SeatRepo extends CrudRepository<Seat, Integer> {

    @Query(value="select * from seat where theatre_id=?1 and is_booked=1", nativeQuery = true)
    List<Seat> findByTheatre(int id);

    @Query(value="select * from seat where theatre_id=?1 and is_booked=0 and is_locked=0", nativeQuery = true)
    List<Seat> findByTheatreFree(int id);

    @Query(value="select * from seat where theatre_id=?1 and is_locked=1", nativeQuery = true)
    List<Seat> findByTheatreLocked(int id);

    @Query(value="select * from seat where screen_id=?1 and is_booked=1", nativeQuery = true)
    List<Seat> findByScreen(int id);

    @Query(value="select * from seat where screen_id=?1 and is_booked=0 and is_locked=0", nativeQuery = true)
    List<Seat> findByScreenFree(int id);

    @Query(value="select * from seat where screen_id=?1 and is_locked=1", nativeQuery = true)
    List<Seat> findByScreenLocked(int id);
}

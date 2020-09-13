package com.baskibond.seatbooking.services;

import com.baskibond.seatbooking.entities.Booking;
import com.baskibond.seatbooking.entities.Screening;
import com.baskibond.seatbooking.entities.Seat;
import com.baskibond.seatbooking.exception.BookingException;
import com.baskibond.seatbooking.models.BookingRequest;
import com.baskibond.seatbooking.models.PaymentStatus;
import com.baskibond.seatbooking.repositories.BookingRepo;
import com.baskibond.seatbooking.repositories.ScreenRepo;
import com.baskibond.seatbooking.repositories.SeatRepo;
import com.baskibond.seatbooking.repositories.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SeatRepo seatRepo;

    @Autowired
    ScreenRepo screenRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    BookingRepo bookingRepo;

    @Transactional
    public Booking performBooking(BookingRequest bookingRequest) {
        LOGGER.info("Booking Request started for : "+bookingRequest.toString());
        Booking booking=null;
        try{
            Optional<Screening> screening=screenRepo.findById(bookingRequest.getScreenId());
            Optional<Seat> isSeat;
            Seat seat;
            List<Seat> seatList=new ArrayList<>();
            for(int seat_id:bookingRequest.getSeats()){
                isSeat=seatRepo.findById(seat_id);
                if(isSeat.isPresent()){
                    seat=isSeat.get();
                    if(seat.isBooked() || seat.isLocked()){
                        throw new BookingException("One the seat selected is already taken");
                    }
                    seat.setLocked(true);
                    seatRepo.save(seat);
                    seatList.add(seat);
                }else {
                    throw new  BookingException("One the seat selected is Not found something weired happened");
                }
            }
            booking=new Booking();
            booking.setBooked_on(new Date());
            booking.setSeats(seatList);
            booking.setScreening(screening.get());
            booking.setUser(userRepo.findById(bookingRequest.getUserId()).get());
            booking.setPayment_status(PaymentStatus.UNPAID);
            bookingRepo.save(booking);
        }catch (Exception e){
            LOGGER.error("Exception Occurred while Booking the seats : "+e.getMessage());
        }

        LOGGER.info("Booking Request Completed for : "+bookingRequest.toString());
        return booking;
    }
}

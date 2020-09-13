package com.baskibond.seatbooking.jobs;

import com.baskibond.seatbooking.entities.Booking;
import com.baskibond.seatbooking.entities.Seat;
import com.baskibond.seatbooking.models.PaymentStatus;
import com.baskibond.seatbooking.repositories.BookingRepo;
import com.baskibond.seatbooking.repositories.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.List;

@Configuration
@EnableScheduling
@EnableTransactionManagement
public class Scheduler {

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    SeatRepo seatRepo;

    @Transactional
    @Scheduled(fixedDelay = 100000, initialDelay = 100000)
    public void scheduleFixedDelayTask() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);

        List<Booking> bookingList=bookingRepo.findAllUnpaidAndLocked(PaymentStatus.UNPAID.toString());
        List<Seat> seatList;
        for(Booking booking:bookingList){
            seatList=booking.getSeats();
            for(Seat seat: seatList){
                seat.setLocked(false);
                seatRepo.save(seat);
            }
            bookingRepo.save(booking);
        }
    }

    @Transactional
    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void scheduleFixedDelayTaskOfMarkingPaid() {
        System.out.println(
                "Fixed delay task - " + System.currentTimeMillis() / 1000);

        List<Booking> bookingList=bookingRepo.findAllUnpaidAndLocked(PaymentStatus.UNPAID.toString());
        List<Seat> seatList;
        for(Booking booking:bookingList){
            seatList=booking.getSeats();
            for(Seat seat: seatList){
                seat.setBooked(true);
                seat.setLocked(false);
                seatRepo.save(seat);
            }
            booking.setPayment_status(PaymentStatus.PAID);
            bookingRepo.save(booking);
        }
    }
}

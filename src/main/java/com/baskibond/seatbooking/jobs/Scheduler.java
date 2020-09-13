package com.baskibond.seatbooking.jobs;

import com.baskibond.seatbooking.entities.Booking;
import com.baskibond.seatbooking.entities.Seat;
import com.baskibond.seatbooking.models.PaymentStatus;
import com.baskibond.seatbooking.repositories.BookingRepo;
import com.baskibond.seatbooking.repositories.SeatRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookingRepo bookingRepo;

    @Autowired
    SeatRepo seatRepo;

    @Transactional
    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void scheduleUnbloackTask() {
        LOGGER.info("Job Started to unblock the seats which have being locked and payment not completed within 10 mins");
        try{
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
        }catch (Exception e){
            LOGGER.error("Exception Occurred : "+e.getMessage());
        }
        LOGGER.info("Job scheduleUnbloackTask Ended");
    }

    @Transactional
    @Scheduled(fixedDelay = 10000, initialDelay = 10000)
    public void scheduleFixedDelayTaskOfMarkingPaid() {
        LOGGER.info("Job to act as Stub for payment system started");
        try{
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
        }catch (Exception e){
            LOGGER.error("Exception Occurred : "+e.getMessage());
        }
        LOGGER.error("Job scheduleFixedDelayTaskOfMarkingPaid ended");
    }
}

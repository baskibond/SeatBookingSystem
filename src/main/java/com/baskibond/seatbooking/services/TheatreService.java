package com.baskibond.seatbooking.services;

import com.baskibond.seatbooking.entities.Movie;
import com.baskibond.seatbooking.entities.Screening;
import com.baskibond.seatbooking.entities.Seat;
import com.baskibond.seatbooking.entities.Theatre;
import com.baskibond.seatbooking.exception.BookingException;
import com.baskibond.seatbooking.models.ScreenRequest;
import com.baskibond.seatbooking.repositories.MovieRepo;
import com.baskibond.seatbooking.repositories.ScreenRepo;
import com.baskibond.seatbooking.repositories.SeatRepo;
import com.baskibond.seatbooking.repositories.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreService {

    @Autowired
    TheatreRepo theatreRepo;

    @Autowired
    SeatRepo seatRepo;

    @Autowired
    ScreenRepo screenRepo;

    @Autowired
    MovieRepo movieRepo;

    public Theatre addTheatre(Theatre theatre) {
//        Seat seat;
//        for(int i=0; i< theatre.getNoOfSeates();i++){
//            seat=new Seat(i);
//            seat.setTheatre(theatre);
//            theatre.getSeatList().add(seat);
//        }
        return theatreRepo.save(theatre);
    }

    public Screening addScreen(ScreenRequest screenRequest) {
        Seat seat;
        Screening screening=new Screening();
        Optional<Movie> movie = movieRepo.findById(screenRequest.getMovieId());
        Optional<Theatre> theatre = theatreRepo.findById(screenRequest.getTheatreId());
        if(theatre.isPresent() && movie.isPresent()){
            screening.setMovie(movie.get());
            screening.setTheatre(theatre.get());
            for(int i=0; i< theatre.get().getNoOfSeates();i++){
                seat=new Seat(i);
                seat.setScreening(screening);
                screening.getSeatList().add(seat);
            }
            return screenRepo.save(screening);
        }
        throw new BookingException("Bad Data, Either Theatre or Movie does not exists");
    }

    public Optional<Screening> getScreen(int screenId) {

        return screenRepo.findById(screenId);
    }

    public Optional<Theatre> getTheatre(int theatre_id) {
        return theatreRepo.findById(theatre_id);
    }

    public List<Seat> getBookedList(int theatre_id) {
        return seatRepo.findByScreen(theatre_id);
    }

    public List<Seat> getUnBookedList(int theatre_id) {
        return seatRepo.findByScreenFree(theatre_id);
    }

    public List<Seat> getProgressedList(int theatre_id) {
        return seatRepo.findByScreenLocked(theatre_id);
    }
}

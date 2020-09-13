package com.baskibond.seatbooking.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties("inspection")
public class Screening {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @JsonBackReference(value = "movie_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theatre_id", nullable = false)
    private Theatre theatre;

    Date startTime;
    Date endTime;

    @JsonManagedReference
    @OneToMany(mappedBy = "screening" ,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    List<Seat> seatList=new ArrayList<>();
}

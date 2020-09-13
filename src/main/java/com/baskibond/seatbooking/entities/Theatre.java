package com.baskibond.seatbooking.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String city;
    private Integer noOfSeates;
    @JsonManagedReference
    @OneToMany(mappedBy = "theatre" ,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    List<Screening> screenings=new ArrayList<>();

//    @JsonManagedReference
//    @OneToMany(mappedBy = "theatre" ,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//    List<Seat> seatList=new ArrayList<>();

}

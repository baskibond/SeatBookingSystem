package com.baskibond.seatbooking.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String director;
    private Integer duration;

    @JsonManagedReference(value = "movie_id")
    @OneToMany(mappedBy = "movie" ,cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    List<Screening> screenings=new ArrayList<>();
}

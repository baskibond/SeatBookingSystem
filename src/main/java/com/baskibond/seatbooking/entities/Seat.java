package com.baskibond.seatbooking.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private int row_id;
    private int coulum_id;
    //@JsonBackReference
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "theatre_id", nullable = false)
//    private Theatre theatre;
    @Column(columnDefinition = "boolean default false")
    boolean isBooked ;
    @Column(columnDefinition = "boolean default false")
    boolean isLocked;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id", nullable = false)
    private Screening screening;

    public Seat(int row_id){
        this.row_id=row_id;
    }
}

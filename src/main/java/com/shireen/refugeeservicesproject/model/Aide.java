package com.shireen.refugeeservicesproject.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Aide {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="AideID")
    private Long aideId;

    @Column(name="AideType")
    private String aideType;

    @Column(name="AideDate")
    private Date aideDate;

    @Column(name="Notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name="RefugeeID")
    private Refugee refugee;

    @ManyToOne
    @JoinColumn(name="VolunteerID")
    private Volunteer volunteer;

    @Column(name="Status")
    private String status;


}



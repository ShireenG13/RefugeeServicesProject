package com.shireen.refugeeservicesproject.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ItemID")
    private Long itemId;

    @Column(name="ItemType")
    private String itemType;

    @Column(name="ItemDescription")
    private String itemDescription;

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

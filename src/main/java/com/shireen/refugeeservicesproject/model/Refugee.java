package com.shireen.refugeeservicesproject.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude="volunteers")

public class Refugee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RefugeeID")
    private Long refugeeId;

    @NotNull
    @Column(name="FirstName")
    private String firstName;

    @NotNull
    @Column(name="LastName")
    private String lastName;

    @Column(name="DateOfBirth")
    private Date dateOfBirth;

    @Column(name="Email")
    private String email;

    @NotNull
    @Column(name="Phone")
    private String phone;

    @Column(name="Address")
    private String address;

    @Column(name="CountryOfOrigin")
    private String countryOfOrigin;

    @Column(name="FamilyCount")
    private int familyCount;

    @Column(name ="Area")
    private String area;

   @OneToMany(mappedBy="refugee", cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    private Set<Aide> aides = new HashSet<>();

   @ManyToMany(mappedBy ="refugees", cascade={CascadeType.PERSIST}, fetch=FetchType.LAZY)
    private Set<Volunteer> volunteers = new HashSet<>();



}

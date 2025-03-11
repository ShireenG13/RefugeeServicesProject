package com.shireen.refugeeservicesproject.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;
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
    private String first_name;

    @NotNull
    @Column(name="LastName")
    private String last_name;

    @Column(name="DateOfBirth")
    private LocalDate date_of_birth;

    @Column(name="Email")
    private String email;

    @NotNull
    @Column(name="Phone")
    private String phone;

    @NotNull
    @Column(name="Password")
    private String password;

    @Column(name="Address")
    private String address;

    @Column(name="CountryOfOrigin")
    private String country_of_origin;

    @Column(name="FamilyCount")
    private int family_count;

    @Column(name="Area")
    private String area;

    @Column(name="Role")
    private String role;

   @OneToMany(mappedBy="refugee", cascade={CascadeType.ALL}, fetch=FetchType.LAZY)
    private Set<Aide> aides = new HashSet<>();

   @ManyToMany(mappedBy ="refugees", cascade={CascadeType.PERSIST}, fetch=FetchType.LAZY)
    private Set<Volunteer> volunteers = new HashSet<>();



}

package com.shireen.refugeeservicesproject.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@ToString(exclude={"refugees","aides"})
public class Volunteer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="VolunteerID")
    private Long volunteerId;

    @Column(name="FirstName")
    private String first_name;

    @Column(name="LastName")
    private String last_name;

    @Column(name="DateOfBirth")
    private LocalDate date_of_birth;

    @Column(name="Email")
    private String email;

    @Column(name="Password")
    private String password;

    @Column(name="Phone")
    private String phone;

    @Column(name="Address")
    private String address;

    @Column(name="EmergencyContact")
    private String emergency_contact;

    @Column(name="Relationship")
    private String relationship;

    @Column(name="ContactPhone")
    private String contact_phone;

    @OneToMany(mappedBy="volunteer",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<Aide> aides =new HashSet<>();

    @ManyToMany(cascade={CascadeType.PERSIST}, fetch=FetchType.LAZY)
    @JoinTable(
            name="Volunteer_Refugee",
            joinColumns = @JoinColumn(name="VolunteerID"),
            inverseJoinColumns = @JoinColumn(name="RefugeeID")
    )
    private Set<Refugee> refugees=new HashSet<>();


}

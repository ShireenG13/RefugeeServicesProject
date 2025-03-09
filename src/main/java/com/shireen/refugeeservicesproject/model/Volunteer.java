package com.shireen.refugeeservicesproject.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private String firstName;

    @Column(name="LastName")
    private String lastName;

    @Column(name="DateOfBirth")
    private Date dateOfBirth;

    @Column(name="Email")
    private String email;

    @Column(name="Phone")
    private String phone;

    @Column(name="Address")
    private String address;

    @Column(name="EmergencyContact")
    private String contactName;

    @Column(name="Relationship")
    private String contactRel;

    @Column(name="ContactPhone")
    private String contactPhone;

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

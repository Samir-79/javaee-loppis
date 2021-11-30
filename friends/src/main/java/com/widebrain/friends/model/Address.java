package com.widebrain.friends.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;

import javax.persistence.*;

//@Embeddable
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String street;
    private String city;

    //USING A BACK REFERENCE WITH A FOREIGN KEY IN THE DATABASE
//     @JsonBackReference
//     @ManyToOne
//     Friend friend;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

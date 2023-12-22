package com.telran.simplespringbootproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class City {

    @Id
    private Long id;

    private String name;

    private double population;

    @ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country country;

}

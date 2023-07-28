package ru.uxair.flight.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name="destinations")

public class Destination {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String airportCode;
    private String city;
    private String countryCode;
    private String countryName;
    private String airportName;
    private String timezone;
}

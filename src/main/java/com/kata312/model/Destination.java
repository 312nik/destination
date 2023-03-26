package ru.uxair.flight.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name="destinations")
public class Destination {
    @Id
    private String airportCode;
    private String city;
    private String countryCode;
    private String countryName;
    private String airportName;
    private String timezone;
}


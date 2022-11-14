package com.jpmc.theater.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private String title;
    private String description;
    private int durationInMins;
    private Double ticketPrice;
    private Integer specialCode;
}
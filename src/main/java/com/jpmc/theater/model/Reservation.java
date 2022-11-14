package com.jpmc.theater.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private Customer customer;
    private Showing showing;
    private Integer audienceCount;
}
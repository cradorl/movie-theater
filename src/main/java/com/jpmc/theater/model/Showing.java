package com.jpmc.theater.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Showing {
    private Movie movie;
    private Integer sequenceOfTheDay;
    private LocalDateTime showStartTime;
}

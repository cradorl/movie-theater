package com.jpmc.theater.service;

import com.jpmc.theater.model.Reservation;

import java.util.UUID;

public interface ReservationService {
    UUID reserve(Reservation reservation);
}

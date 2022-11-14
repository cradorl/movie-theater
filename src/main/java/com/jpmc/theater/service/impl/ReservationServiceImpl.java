package com.jpmc.theater.service.impl;

import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.service.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class ReservationServiceImpl implements ReservationService {

    @Override
    public UUID reserve(Reservation reservation) {
        log.info("Reservation code generation");
        return UUID.randomUUID();
    }

}

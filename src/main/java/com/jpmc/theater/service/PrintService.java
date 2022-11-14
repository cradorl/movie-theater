package com.jpmc.theater.service;

import com.jpmc.theater.model.Showing;

import java.util.List;

public interface PrintService {
    List<Showing> printShowingsInJsonFormat();

    String printShowingsInStringFormat();
}

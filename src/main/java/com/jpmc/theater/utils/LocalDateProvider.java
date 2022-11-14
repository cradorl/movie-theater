package com.jpmc.theater.utils;

import java.time.LocalDate;

public enum LocalDateProvider {
    INSTANCE;

    public LocalDate currentDate() {
        return LocalDate.now();
    }
}

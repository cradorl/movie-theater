package com.jpmc.theater.model.discount.impl;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeDiscountImplTest {
    @InjectMocks
    private TimeDiscountImpl timeDiscount;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void should_return_zeroDiscount_when_timeIsNotBetween_11AM_and_4PM() {
        //given
        Showing showing = new Showing();
        showing.setShowStartTime(LocalDateTime.of(2022, 11, 14, 18, 24));

        //when
        double actualResult = timeDiscount.applyDiscount(showing);

        //then
        assertEquals(0.0, actualResult);
    }

    @Test
    void should_return_appliedDiscount_when_timeIsBetween_11AM_and_4PM() {
        //given
        Movie movie = new Movie();
        movie.setTicketPrice(10.0);

        Showing showing = new Showing();
        showing.setMovie(movie);
        showing.setShowStartTime(LocalDateTime.of(2022, 11, 14, 12, 24));

        //when
        double expectedResult = timeDiscount.applyDiscount(showing);

        //then
        assertEquals(2.5, expectedResult);
    }

}
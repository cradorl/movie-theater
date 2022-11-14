package com.jpmc.theater.model.discount.impl;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpecialDiscountImplTest {
    @InjectMocks
    private SpecialDiscountImpl specialDiscount;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void should_return_zeroDiscount_when_codeIsNotSpecial() {
        //given
        Movie movie = new Movie();
        ;
        movie.setSpecialCode(5);
        Showing showing = new Showing();
        showing.setMovie(movie);

        //when
        double actualResult = specialDiscount.applyDiscount(showing);

        //then
        assertEquals(0.0, actualResult);
    }

    @Test
    void should_return_appliedDiscount_when_codeIsSpecial() {
        //given
        Movie movie = new Movie();
        ;
        movie.setSpecialCode(1);
        movie.setTicketPrice(10.0);
        Showing showing = new Showing();
        showing.setMovie(movie);

        //when
        double actualResult = specialDiscount.applyDiscount(showing);

        //then
        assertEquals(2.0, actualResult);
    }


}
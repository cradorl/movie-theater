package com.jpmc.theater.model.discount.impl;

import com.jpmc.theater.model.Showing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayDiscountImplTest {
    @InjectMocks
    private DayDiscountImpl dayDiscount;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void should_return_zeroDiscount_when_dayIsNotSpecial() {
        //given
        Showing showing = new Showing();
        showing.setSequenceOfTheDay(5);

        //when
        double actualResult = dayDiscount.applyDiscount(showing);

        //then
        assertEquals(0.0, actualResult);
    }

    @Test
    void should_return_3$Discount_when_itIsFirstDay() {
        //given
        Showing showing = new Showing();
        showing.setSequenceOfTheDay(1);

        //when
        double actualResult = dayDiscount.applyDiscount(showing);

        //then
        assertEquals(3.0, actualResult);
    }

    @Test
    void should_return_2$Discount_when_itIsFirstDay() {
        //given
        Showing showing = new Showing();
        showing.setSequenceOfTheDay(2);

        //when
        double actualResult = dayDiscount.applyDiscount(showing);

        //then
        assertEquals(2.0, actualResult);
    }

    @Test
    void should_return_1$Discount_when_itIsFirstDay() {
        //given
        Showing showing = new Showing();
        showing.setSequenceOfTheDay(7);

        //when
        double actualResult = dayDiscount.applyDiscount(showing);

        //then
        assertEquals(1.0, actualResult);
    }

}
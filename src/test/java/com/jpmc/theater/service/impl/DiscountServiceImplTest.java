package com.jpmc.theater.service.impl;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.model.discount.Discount;
import com.jpmc.theater.model.discount.impl.DayDiscountImpl;
import com.jpmc.theater.model.discount.impl.SpecialDiscountImpl;
import com.jpmc.theater.model.discount.impl.TimeDiscountImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DiscountServiceImplTest {
    @Mock
    DayDiscountImpl dayDiscount;

    @Mock
    SpecialDiscountImpl specialDiscount;

    @Mock
    TimeDiscountImpl timeDiscount;

    @Mock
    List<Discount> discountList;

    @InjectMocks
    DiscountServiceImpl discountService;

    @Mock
    Iterator<Discount> discountIterator;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);

        when(discountList.iterator()).thenReturn(discountIterator);
        when(discountIterator.hasNext()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
    }


    @Test
    void should_return_maxDiscount_when_DiscountWasConfigured() {
        //given
        Showing showing = new Showing();
        when(discountIterator.next())
                .thenReturn(dayDiscount)
                .thenReturn(specialDiscount)
                .thenReturn(timeDiscount);
        when(dayDiscount.applyDiscount(ArgumentMatchers.any(Showing.class)))
                .thenReturn(2.0);
        when(specialDiscount.applyDiscount(ArgumentMatchers.any(Showing.class)))
                .thenReturn(9.0);
        when(timeDiscount.applyDiscount(ArgumentMatchers.any(Showing.class)))
                .thenReturn(5.0);

        //when
        Double discountPrice = discountService.getDiscountPrice(showing);

        //then
        assertEquals(9.0, discountPrice);
    }

    @Test
    void should_return_zeroDiscount_when_DiscountIsNotConfigured() {
        //given
        when(discountIterator.hasNext()).thenReturn(false);
        Showing showing = new Showing();

        //when
        Double discountPrice = discountService.getDiscountPrice(showing);

        //then
        assertEquals(0.0, discountPrice);
    }

}
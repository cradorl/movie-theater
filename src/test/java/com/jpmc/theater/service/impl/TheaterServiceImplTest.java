package com.jpmc.theater.service.impl;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.service.DiscountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TheaterServiceImplTest {

    @Mock
    private DiscountService discountService;

    @InjectMocks
    private TheaterServiceImpl theaterServiceImpl;

    @Test
    public void should_return_totalFeeWithDiscount_when_discountWasApplied() {
        //given
        Movie movie = new Movie();
        movie.setTicketPrice(10.0);
        Showing showing = new Showing();
        showing.setMovie(movie);
        when(discountService.getDiscountPrice(ArgumentMatchers.any(Showing.class)))
                .thenReturn(1.0);

        //when
        double totalFee = theaterServiceImpl.getShowingFee(showing);

        //then
        assertEquals(9.0, totalFee);
    }

    @Test
    public void should_return_zeroTotalFee_when_discountIsBiggerThanTicketPrice() {
        //given
        Movie movie = new Movie();
        movie.setTicketPrice(2.0);
        Showing showing = new Showing();
        showing.setMovie(movie);
        when(discountService.getDiscountPrice(ArgumentMatchers.any(Showing.class)))
                .thenReturn(3.0);

        //when
        double totalFee = theaterServiceImpl.getShowingFee(showing);

        //then
        assertEquals(0.0, totalFee);
    }


}
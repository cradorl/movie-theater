package com.jpmc.theater.model.discount.impl;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.model.discount.Discount;
import lombok.extern.slf4j.Slf4j;

import static com.jpmc.theater.constant.DiscountConstants.*;

@Slf4j
public class TimeDiscountImpl implements Discount {

    @Override
    public Double applyDiscount(Showing showing) {
        log.info("Applying discount for special time");

        int showingHour = showing.getShowStartTime().getHour();

        if (showingHour > MOVIE_TIME_11_AM && showingHour < MOVIE_TIME_4_PM) {
            return showing.getMovie().getTicketPrice() * MOVIE_11AM_4PM_DISCOUNT;
        }

        return ZERO_DISCOUNT;
    }

}

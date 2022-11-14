package com.jpmc.theater.model.discount.impl;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.model.discount.Discount;
import lombok.extern.slf4j.Slf4j;

import static com.jpmc.theater.constant.DiscountConstants.*;

@Slf4j
public class DayDiscountImpl implements Discount {

    @Override
    public Double applyDiscount(Showing showing) {
        log.info("Applying discount for special day");

        switch (showing.getSequenceOfTheDay()) {
            case FIRST_DAY: {
                return MOVIE_FIRST_DAY_DISCOUNT;
            }
            case SECOND_DAY: {
                return MOVIE_SECOND_DAY_DISCOUNT;
            }
            case SEVENTH_DAY: {
                return MOVIE_SEVENTH_DAY_DISCOUNT;
            }
            default:
                return ZERO_DISCOUNT;
        }
    }

}

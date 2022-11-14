package com.jpmc.theater.model.discount.impl;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.model.discount.Discount;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

import static com.jpmc.theater.constant.DiscountConstants.*;

@Slf4j
public class SpecialDiscountImpl implements Discount {

    @Override
    public Double applyDiscount(Showing showing) {
        log.info("Applying discount for special movie");

        Movie movie = showing.getMovie();
        double discount = ZERO_DISCOUNT;

        if (Objects.equals(movie.getSpecialCode(), MOVIE_SPECIAL_CODE)) {
            discount = movie.getTicketPrice() * MOVIE_SPECIAL_CODE_DISCOUNT;
        }

        return discount;
    }

}

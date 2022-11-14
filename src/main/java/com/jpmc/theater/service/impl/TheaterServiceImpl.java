package com.jpmc.theater.service.impl;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.service.DiscountService;
import com.jpmc.theater.service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    DiscountService discountService;

    @Override
    public Double getShowingFee(Showing showing) {
        log.info("Getting showing fee");
        double showingFee = showing.getMovie().getTicketPrice() - discountService.getDiscountPrice(showing);
        return Math.max(showingFee, 0.0);
    }

}

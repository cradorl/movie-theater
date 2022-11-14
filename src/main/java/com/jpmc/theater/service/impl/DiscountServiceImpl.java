package com.jpmc.theater.service.impl;

import com.jpmc.theater.model.Showing;
import com.jpmc.theater.model.discount.Discount;
import com.jpmc.theater.service.DiscountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jpmc.theater.constant.DiscountConstants.ZERO_DISCOUNT;

@Service
@Slf4j
public class DiscountServiceImpl implements DiscountService {

    @Autowired(required = false)
    private List<Discount> discountList;

    @Override
    public Double getDiscountPrice(Showing showing) {
        log.info("Getting max discount");

        Double maxDiscount = ZERO_DISCOUNT;

        if (discountList != null && !discountList.isEmpty()) {
            for (Discount discount : discountList) {
                maxDiscount = Math.max(maxDiscount, discount.applyDiscount(showing));
            }
        }

        return maxDiscount;
    }

}

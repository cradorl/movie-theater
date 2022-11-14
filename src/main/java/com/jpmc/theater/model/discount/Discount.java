package com.jpmc.theater.model.discount;

import com.jpmc.theater.model.Showing;

public interface Discount {

    Double applyDiscount(Showing showing);

}

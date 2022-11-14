package com.jpmc.theater;

import com.jpmc.theater.utils.LocalDateProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovieTheaterApplicationTest {

    @Test
    public void should_return_theSameInstance() {
        LocalDateProvider LocalDateProviderInstance1 = LocalDateProvider.INSTANCE;
        LocalDateProvider LocalDateProviderInstance2 = LocalDateProvider.INSTANCE;

        assertEquals(LocalDateProviderInstance1, LocalDateProviderInstance2);
    }

}
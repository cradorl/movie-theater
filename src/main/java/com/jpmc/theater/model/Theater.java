package com.jpmc.theater.model;

import com.jpmc.theater.utils.LocalDateProvider;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
public class Theater {
    public static LocalDateProvider provider;
    public static List<Showing> schedule;

    static {
        provider = LocalDateProvider.INSTANCE;
        Movie spiderMan = new Movie("Spider-Man: No Way Home", "Description for Spider-Man: No Way Home", 90, 12.5, 1);
        Movie turningRed = new Movie("Turning Red", "Description for Turning Red", 85, 11.0, 0);
        Movie theBatMan = new Movie("The Batman", "Description for The Batman", 95, 9.0, 0);
        schedule = List.of(
                new Showing(turningRed, 1, LocalDateTime.of(provider.currentDate(), LocalTime.of(9, 0))),
                new Showing(spiderMan, 2, LocalDateTime.of(provider.currentDate(), LocalTime.of(11, 0))),
                new Showing(theBatMan, 3, LocalDateTime.of(provider.currentDate(), LocalTime.of(12, 50))),
                new Showing(turningRed, 4, LocalDateTime.of(provider.currentDate(), LocalTime.of(14, 30))),
                new Showing(spiderMan, 5, LocalDateTime.of(provider.currentDate(), LocalTime.of(16, 10))),
                new Showing(theBatMan, 6, LocalDateTime.of(provider.currentDate(), LocalTime.of(17, 50))),
                new Showing(turningRed, 7, LocalDateTime.of(provider.currentDate(), LocalTime.of(19, 30))),
                new Showing(spiderMan, 8, LocalDateTime.of(provider.currentDate(), LocalTime.of(21, 10))),
                new Showing(theBatMan, 9, LocalDateTime.of(provider.currentDate(), LocalTime.of(23, 0)))
        );
    }

    public static List<Showing> getSchedule() {
        return schedule;
    }
}

package com.jpmc.theater.service.impl;

import com.jpmc.theater.utils.LocalDateProvider;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.model.Theater;
import com.jpmc.theater.service.PrintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class PrintServiceImpl implements PrintService {

    @Override
    public List<Showing> printShowingsInJsonFormat() {
        log.info("Printing showings in json format");
        return Theater.getSchedule();

    }

    @Override
    public String printShowingsInStringFormat() {
        log.info("Printing showings in text format");

        StringBuilder showingsInTextFormat = new StringBuilder(
                LocalDateProvider.INSTANCE.currentDate().toString());

        showingsInTextFormat.append("=========================================");

        List<Showing> schedule = Theater.getSchedule();
        schedule.forEach(showing ->
                showingsInTextFormat.append(showing.getSequenceOfTheDay() + ": "
                        + showing.getShowStartTime() + ", " + showing.getMovie().getTitle() + ", "
                        + getDuration(showing.getMovie().getDurationInMins())
                        + ", $" + showing.getMovie().getTicketPrice())
        );

        showingsInTextFormat.append("=========================================");

        return showingsInTextFormat.toString();
    }

    public static String getDuration(int durationInMins) {
        log.info("Getting duration");
        Duration duration = Duration.ofMinutes(durationInMins);
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    private static String handlePlural(long value) {
        log.info("Handle plural");
        if (value == 1) {
            return "";
        } else {
            return "s";
        }
    }

}

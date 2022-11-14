package com.jpmc.theater.controler;

import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.service.DiscountService;
import com.jpmc.theater.service.PrintService;
import com.jpmc.theater.service.ReservationService;
import com.jpmc.theater.service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/movie-theater")
public class MovieTheaterController {

    @Autowired
    private PrintService printService;

    @Autowired
    private DiscountService discountService;

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private ReservationService reservationService;


    @GetMapping(value = "/printShowings/json")
    public ResponseEntity<List<Showing>> printShowingsInJsonFormat() {
        log.info("Request for printing showings in json format");

        return new ResponseEntity<>(printService.printShowingsInJsonFormat(), HttpStatus.OK);
    }

    @GetMapping(value = "/printShowings/text")
    public ResponseEntity<String> printShowingsInTextFormat() {
        log.info("Request for printing showings in text format");

        return new ResponseEntity<>(printService.printShowingsInStringFormat(), HttpStatus.OK);
    }

    @GetMapping(value = "/showingFee")
    public ResponseEntity<Double> getShowingFee(@RequestBody Showing showing) {
        log.info("Request for getting showing fee");
        return new ResponseEntity<>(theaterService.getShowingFee(showing), HttpStatus.OK);
    }

    @GetMapping(value = "/totalShowingFee/{audienceCount}")
    public ResponseEntity<Double> getTotalShowingFee(
            @PathVariable(name = "audienceCount") Integer audienceCount,
            @RequestBody Showing showing) {
        log.info("Request for getting total showing fee");
        return new ResponseEntity<>(
                theaterService.getShowingFee(showing) * audienceCount, HttpStatus.OK);
    }

    @PostMapping(value = "/reserveShowing")
    public ResponseEntity<UUID> reserve(@RequestBody Reservation reservation) {
        log.info("Request for reserving the showing");
        return new ResponseEntity<>(reservationService.reserve(reservation), HttpStatus.CREATED);
    }

}

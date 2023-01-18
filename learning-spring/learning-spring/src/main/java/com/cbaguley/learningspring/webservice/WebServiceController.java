package com.cbaguley.learningspring.webservice;

import java.util.Date;
import java.util.List;

import com.cbaguley.learningspring.business.ReservationService;
import com.cbaguley.learningspring.business.RoomReservation;
import com.cbaguley.learningspring.util.DateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebServiceController {
    private final DateUtils dateUtils;
    private final ReservationService reservationService;

    public WebServiceController(DateUtils dateUtils, ReservationService reservationService) {
        this.dateUtils = dateUtils;
        this.reservationService = reservationService;
    }

    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<RoomReservation> getReservations(@RequestParam(value="date", required = false)String dateString){
        Date date = this.dateUtils.createDateFromDateString(dateString);
        return this.reservationService.getRoomReservationsForDate(date);
    }
}


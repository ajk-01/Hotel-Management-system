package com.example.hotel_manage.controller;

import com.example.hotel_manage.dto.request.CreateReservation;
import com.example.hotel_manage.dto.response.ReservationResult;
import com.example.hotel_manage.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/get-all-reservations")
    @PreAuthorize("hasRole('admin')")
    public List<ReservationResult> getAllReservation() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/get-by-id/reservations/{id}")
    @PreAuthorize("hasRole('admin')")
    public List<ReservationResult> getReservationsByID(@PathVariable("id") Long id) {
        return (List<ReservationResult>) reservationService.getReservationById(id);
    }

    @GetMapping("/get-by-UserId/reservations/User/{id}")
    @PreAuthorize("hasRole('admin')")
    public List<ReservationResult> ReservationByUser(@PathVariable("id") Long id) {
        return reservationService.getReservationsByUser(id);
    }

    @GetMapping("/get-reservations-of-room/{id}")
    @PreAuthorize("hasRole('admin')")
    public List<ReservationResult> RoomReservation(@PathVariable("id") Long id) {
        return reservationService.getReservationsByRoom(id);
    }

    @GetMapping("/get-reservations-of_period")
    @PreAuthorize("hasRole('admin')")
    public List<ReservationResult> ReservationInTimePeriod(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        return reservationService.getReservationsInDateRange(startDate, endDate);
    }

    @PostMapping("/create-reservation")
    public List<ReservationResult> CreateReservation(@RequestBody CreateReservation createReservation) {
        return reservationService.createReservation(createReservation);
    }

    @PutMapping("/update-reservations-by-Id/{id}")
    public List<ReservationResult> editReservation(@PathVariable("id") Long id, @RequestBody CreateReservation updateReservation) {
        return reservationService.updateReservation(id, updateReservation);
    }
@DeleteMapping("/delete_reservation/{id}")
    public List<ReservationResult> deleteReservation(@PathVariable("id") Long id)
{
    return reservationService.cancelReservation(id);
}
}

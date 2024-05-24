package com.example.hotel_manage.service;

import com.example.hotel_manage.dto.request.CreateReservation;
import com.example.hotel_manage.dto.response.ReservationResult;
import com.example.hotel_manage.entity.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    List<ReservationResult> getAllReservations();

    Reservation getReservationById(Long reservationId);

    List<ReservationResult> getReservationsByUser(Long userId);

    List<ReservationResult> getReservationsByRoom(Long roomId);

    List<ReservationResult> getReservationsInDateRange(LocalDate startDate, LocalDate endDate);


    List<ReservationResult> createReservation(CreateReservation reservation);


    List<ReservationResult> updateReservation(Long id, CreateReservation updateReservation);

    List<ReservationResult> cancelReservation(Long reservationId);
}

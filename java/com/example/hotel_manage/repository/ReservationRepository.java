package com.example.hotel_manage.repository;

import com.example.hotel_manage.dto.response.ReservationResult;
import com.example.hotel_manage.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation ,Long> {
    List<ReservationResult> findByRoomId(Long roomId);

    List<ReservationResult> findByUserId(Long userId);

    List<ReservationResult> findByStartDateBetweenAndEndDateBetween(LocalDate startDate, LocalDate endDate, LocalDate startDate1, LocalDate endDate1);

    Optional<Reservation> getReservationById(Long id);

    List<Reservation> findRoomReservationsInDateRange(Long roomId, LocalDate startDate, LocalDate endDate);
}

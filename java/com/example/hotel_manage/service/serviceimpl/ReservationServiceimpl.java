package com.example.hotel_manage.service.serviceimpl;

import com.example.hotel_manage.dto.request.CreateReservation;
import com.example.hotel_manage.dto.response.PayResult;
import com.example.hotel_manage.dto.response.ReservationResult;
import com.example.hotel_manage.dto.response.RoomsResult;
import com.example.hotel_manage.entity.Pay;
import com.example.hotel_manage.entity.Reservation;
import com.example.hotel_manage.entity.Rooms;
import com.example.hotel_manage.entity.User;
import com.example.hotel_manage.repository.PayRepository;
import com.example.hotel_manage.repository.ReservationRepository;
import com.example.hotel_manage.repository.RoomsRepository;
import com.example.hotel_manage.repository.UserRepository;
import com.example.hotel_manage.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReservationServiceimpl implements ReservationService {
        @Autowired
        private ReservationRepository reservationRepository;
        @Autowired
        private RoomsServiceimpl roomService;
        @Autowired
        private RoomsRepository roomsRepository;
        @Autowired
        private PayRepository payRepository;
        @Autowired
        private UserRepository userRepository;
  @Override
        public List<ReservationResult> getAllReservations() {
            return reservationRepository.findAll().stream().map(reservation -> new ReservationResult(reservation.getId(),reservation.getStartDate(),reservation.getEndDate(),
                    new PayResult(reservation.getPay().getTotal_pay(),
                            reservation.getPay().getId(), reservation.getPay().getReservation()),
                    new RoomsResult(reservation.getRooms().getId(), reservation.getRooms().getRoom_type(),reservation.getRooms().getStatus()
                    ,reservation.getRooms().getRoom_no(),reservation.getRooms().getRoom_rate()))).collect(Collectors.toList());
        }
@Override
        public Reservation getReservationById(Long id) {
            return reservationRepository.findById(id).orElse(null);
  }
@Override //return reservations done by single user using its userId
        public List<ReservationResult> getReservationsByUser(Long userId) {
            return reservationRepository.findByUserId(userId);
        }
@Override //return reservations of a room
        public List<ReservationResult> getReservationsByRoom(Long roomId) {
            return reservationRepository.findByRoomId(roomId);
        }
@Override
        public List<ReservationResult> getReservationsInDateRange(LocalDate startDate, LocalDate endDate) {
            List<ReservationResult> reserve= reservationRepository.findByStartDateBetweenAndEndDateBetween(startDate, endDate, startDate, endDate);
            return reserve;
        }

@Override
        public List<ReservationResult> createReservation(CreateReservation createReservation) {
    Pay pay= payRepository.getReferenceById(CreateReservation.getPayId().getClass());
    User user=userRepository.getReferenceById(CreateReservation.getUserId().getClass());
    Rooms rooms=roomsRepository.getReferenceById(CreateReservation.getRoomId(roomService.findAvailableRooms()).getClass());
    Reservation reservation=new Reservation(CreateReservation.getStartDate(),CreateReservation.getEndDate(),user,rooms,pay);
            return (List<ReservationResult>) reservationRepository.save(reservation);
        }
@Override
        public List<ReservationResult> updateReservation(Long id, CreateReservation updateReservation) {
    Optional<Reservation> existingReservation = reservationRepository.getReservationById(id);
    if(existingReservation.isPresent()) {
        Reservation reservation = existingReservation.get();
        reservation.setStartDate(updateReservation.getStartDate());
        reservation.setEndDate(updateReservation.getEndDate());
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            reservation.setUser(existingUser.get());
        }
        Optional<Rooms> existingRoom = roomsRepository.findById(id);
        if (existingRoom.isPresent()) {
            reservation.setRooms(existingRoom.get());
        }
        Optional<Pay> existingPayment = payRepository.findById(id);
        if (existingPayment.isPresent()) {
            reservation.setPay(existingPayment.get());
        }

        reservationRepository.save(reservation);
    }
    return getAllReservations();
        }
@Override
        public List<ReservationResult> cancelReservation(Long reservationId) {
         reservationRepository.deleteById(reservationId);
    return null;
}
    }


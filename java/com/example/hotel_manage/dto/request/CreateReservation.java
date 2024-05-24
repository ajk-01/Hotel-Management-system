package com.example.hotel_manage.dto.request;

import com.example.hotel_manage.dto.response.RoomsResult;

import java.time.LocalDate;
import java.util.List;

public class CreateReservation {
    private Integer reservation_no;
    private static Long payId;
    private static Long roomId;
    private static LocalDate startDate;
    private static LocalDate endDate;
    private static Long userId;

    public CreateReservation() {
    }

    public CreateReservation(Integer reservation_no, Long payId, Long roomId) {
        this.reservation_no = reservation_no;
        this.payId = payId;
        this.roomId = roomId;
    }

    public CreateReservation(Long roomId, LocalDate startDate, LocalDate endDate, Long userId) {
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
    }

    public Integer getReservation_no() {
        return reservation_no;
    }

    public void setReservation_no(Integer reservation_no) {
        this.reservation_no = reservation_no;
    }

    public static Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public static Long getRoomId(List<RoomsResult> availableRooms) {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public static LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public static LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public static Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

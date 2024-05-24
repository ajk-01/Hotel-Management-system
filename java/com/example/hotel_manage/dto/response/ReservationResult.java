package com.example.hotel_manage.dto.response;

import java.time.LocalDate;


public class ReservationResult {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;

    private PayResult payResult;
    private RoomsResult roomsResult;

    public ReservationResult() {
    }

    public ReservationResult(Long id, LocalDate startDate, LocalDate endDate, PayResult payResult, RoomsResult roomsResult) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payResult = payResult;
        this.roomsResult = roomsResult;
    }

    public ReservationResult(PayResult payResult, RoomsResult roomsResult) {
        this.payResult = payResult;
        this.roomsResult = roomsResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PayResult getPayResult() {
        return payResult;
    }

    public void setPayResult(PayResult payResult) {
        this.payResult = payResult;
    }

    public RoomsResult getRoomsResult() {
        return roomsResult;
    }

    public void setRoomsResult(RoomsResult roomsResult) {
        this.roomsResult = roomsResult;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

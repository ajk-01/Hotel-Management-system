package com.example.hotel_manage.dto.response;

import com.example.hotel_manage.entity.Pay;
import com.example.hotel_manage.entity.Reservation;

public class PayResult {
    private Long payment;
    private Long id;
    private Reservation reservation;

    public PayResult(Long id, Long pay, Long sgst, Long totalPay, Long reservation) {
    }

    public PayResult() {
    }

    public PayResult(Long payment, Long id, Reservation reservation) {
        this.payment = payment;
        this.id = id;
        this.reservation = reservation;
    }

    public PayResult(Long payment, Reservation reservation) {
        this.payment = payment;
        this.reservation = reservation;
    }

    public Long getPayment() {
        return payment;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public static PayResult fromPay(Pay payment)
    {
        return new PayResult(payment.getId(), payment.getPay(), payment.getSgst(),payment.getTotal_pay(),payment.getReservation().getId());
    }
}

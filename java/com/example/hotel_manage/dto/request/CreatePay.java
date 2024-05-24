package com.example.hotel_manage.dto.request;

public class CreatePay {
    private String payId;
    private Long payment;
    private Long sgst;
    private Long total_payment;
private Long reserveId;
private Long roomId;
private Long userId;
    public CreatePay() {
    }

    public CreatePay(Long payment, Long sgst, Long total_payment, Long reserveId, Long roomId, Long userId) {
        this.payment = payment;
        this.sgst = sgst;
        this.total_payment = total_payment;
        this.reserveId = reserveId;
        this.roomId = roomId;
        this.userId = userId;
    }

    public CreatePay(String payId, Long payment, Long sgst, Long total_payment) {
        this.payId = payId;
        this.payment = payment;
        this.sgst = sgst;
        this.total_payment = total_payment;
    }

    public CreatePay(Long payment, Long sgst, Long total_payment) {
        this.payment = payment;
        this.sgst = sgst;
        this.total_payment = total_payment;
    }

    public String getPayId() {
        return payId;
    }

    public void setPayId(String payId) {
        this.payId = payId;
    }

    public Long getPayment(Long payment) {
        return payment;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
    }

    public Long getPayment() {
        return payment;
    }

    public Long getSgst() {
        return sgst;
    }

    public Long getTotal_payment() {
        return total_payment;
    }

    public Long getSgst(Long sgst) {
        return sgst;
    }

    public void setSgst(Long sgst) {
        this.sgst = sgst;
    }

    public Long getTotal_payment(Long total_payment) {
        return total_payment;
    }


    public void setTotal_payment(Long total_payment) {
        this.total_payment = total_payment;
    }

    public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

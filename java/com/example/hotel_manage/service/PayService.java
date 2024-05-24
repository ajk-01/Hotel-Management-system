package com.example.hotel_manage.service;

import com.example.hotel_manage.dto.request.CreatePay;
import com.example.hotel_manage.dto.response.PayResult;
import com.example.hotel_manage.entity.Reservation;

import java.util.List;

public interface PayService {
    List<PayResult> getPaymentbyId(Long id);

    List<PayResult> getAllPayments();

    List<PayResult> getAllPaymentsByUser(Long Userid);

    List<PayResult> getPaymentByReservation(Long reservationId);

    List<PayResult> updatePaymentAmount(Long paymentId, Long newAmount, Long sgst, CreatePay updatePay);

    List<PayResult> createPayment(CreatePay createPay);

    List<PayResult> cancelPayment(Long paymentId);

    List<PayResult> cancelPaymentwithreservation(Long paymentId, Long reservationId);
}

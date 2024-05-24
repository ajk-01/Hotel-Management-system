package com.example.hotel_manage.controller;

import com.example.hotel_manage.dto.request.CreatePay;
import com.example.hotel_manage.dto.response.PayResult;
import com.example.hotel_manage.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PayController {
@Autowired
    private PayService payService;
@GetMapping("/get-payment-by-id/{id}")
    public List<PayResult> paymentById(@PathVariable("id") Long id)
{
    return (List<PayResult>) payService.getPaymentbyId(id);
}
@GetMapping("/get-all-payments")
@PreAuthorize("hasRole('admin')")
    public List<PayResult> getAllPayment()
{
    return payService.getAllPayments();
}
@GetMapping("/get-all-payment/user/{id}")
    public List<PayResult> getPaymentsByUser(@PathVariable("id") Long id)
{
    return payService.getAllPaymentsByUser(id);
}
@GetMapping("/get-payment/reservation/{id}")
    public List<PayResult> getPaymentsByReservation(@PathVariable("id") Long id)
{
    return payService.getPaymentByReservation(id);
}
@PostMapping("/create-payment")
    public List<PayResult> createPayment(@RequestBody CreatePay createPay)
{
    return payService.createPayment(createPay);
}
@PutMapping("/update-Payment-id/{id}")
    public List<PayResult> editupdate(@PathVariable("id")Long id,@RequestParam("newAmount")Long newAmount,@RequestParam("sgst")Long sgst,@RequestBody CreatePay updatePay) {
    return payService.updatePaymentAmount(id, newAmount, sgst, updatePay);
}
@DeleteMapping("/delete-payment-and-reservation/{id}")
    public List<PayResult> deletePayment(@PathVariable("id")Long id,@RequestParam("reservationId")Long reservationId)
{return payService.cancelPaymentwithreservation(id,reservationId);}
@DeleteMapping("/cancel-payment/{id}")
    public List<PayResult> cancelpayment(@PathVariable("id")Long id)
{return payService.cancelPayment(id);}
}

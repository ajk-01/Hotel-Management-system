package com.example.hotel_manage.service.serviceimpl;

import com.example.hotel_manage.dto.request.CreatePay;
import com.example.hotel_manage.dto.response.PayResult;
import com.example.hotel_manage.entity.Pay;
import com.example.hotel_manage.entity.Reservation;
import com.example.hotel_manage.entity.Rooms;
import com.example.hotel_manage.entity.User;
import com.example.hotel_manage.repository.PayRepository;
import com.example.hotel_manage.repository.ReservationRepository;
import com.example.hotel_manage.repository.RoomsRepository;
import com.example.hotel_manage.repository.UserRepository;
import com.example.hotel_manage.service.PayService;
import com.example.hotel_manage.utlis.Exceptions.PaymentNotFoundException;
import com.example.hotel_manage.utlis.Exceptions.ReservationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PayServiceimpl implements PayService {
    @Autowired
    PayRepository payRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    RoomsRepository roomsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PayResult payResult;

    @Override
    public List<PayResult> getPaymentbyId(Long id) {
        return (List<PayResult>) payRepository.findById(id).orElse(null);
    }

    @Override
    public List<PayResult> getAllPayments() // for hotel management
    {
        return payRepository.findAll().stream()
                .map(pay -> new PayResult(pay.getPay(), pay.getId(), pay.getReservation()))
                .collect(Collectors.toList());
    }
@Override
public List<PayResult> getAllPaymentsByUser(Long Userid)
{
  return   payRepository.findByUserID(Userid);
}
    @Override
    public List<PayResult> getPaymentByReservation(Long reservationId) {
        Pay payment = (Pay) payRepository.findByReservationId(reservationId);
        if (payment != null) {
            payment.getPay();
            payment.getSgst();
            payment.getTotal_pay();
        } else {
            try {
                throw new ReservationNotFoundException("Reservation not found with Id" + reservationId);
            } catch (ReservationNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return (List<PayResult>) payment;
    }

    @Override
    public List<PayResult> updatePaymentAmount(Long paymentId, Long newAmount, Long sgst, CreatePay updatePay) {
      Optional<Pay>  payment = payRepository.findById(paymentId);
      if(payment.isPresent()){
          Pay pay=payment.get();
            pay.setPay(updatePay.getPayment(newAmount));
            pay.setSgst(updatePay.getSgst(sgst));
            pay.setTotal_pay(updatePay.getTotal_payment(newAmount + sgst));
           List<PayResult> payResult= (List<PayResult>) payRepository.save(pay);
        } else {
            try {
                throw new PaymentNotFoundException("payment not found with Id" + paymentId);
            } catch (PaymentNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return (List<PayResult>) payResult;
    }

    @Override
    public List<PayResult> createPayment(CreatePay createPay)
    {
        User user=userRepository.findById(createPay.getUserId()).get();
        Rooms rooms=roomsRepository.findById(createPay.getRoomId()).get();
        Reservation reservation=reservationRepository.findById(createPay.getReserveId()).get();
        Pay pay=new Pay(createPay.getPayId(),createPay.getPayment(),rooms,user,reservation);
        payRepository.save(pay);
        return (List<PayResult>) pay;
    }
    @Override
    public List<PayResult> cancelPayment(Long paymentId) {
        Optional<Pay> payment = payRepository.findById(paymentId);
        if(paymentId!=null)
        {
            payRepository.deleteById(paymentId);
        }
        return null;
    }

    @Override
    public List<PayResult> cancelPaymentwithreservation(Long paymentId, Long reservationId) {
        Optional<Pay> payment= payRepository.findById(paymentId);

        if (payment.isPresent()) {
            Pay pay = payment.get();

            Reservation reservation = pay.getReservation();
            if (reservation != null && reservation.getId().equals(reservationId)) {
                payRepository.deleteById(paymentId);
                reservationRepository.deleteById(reservationId); //cancel registration as well
            }

        }
        return null;
    }
}

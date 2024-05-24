package com.example.hotel_manage.repository;

import com.example.hotel_manage.dto.response.PayResult;
import com.example.hotel_manage.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayRepository extends JpaRepository<Pay,Long> {
    Pay getReferenceById(Class<? extends Long> aClass);

    List<PayResult> findByReservationId(Long reservationId);

    List<PayResult> findByUserID(Long userid);
}

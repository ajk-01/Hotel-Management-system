package com.example.hotel_manage.repository;

import com.example.hotel_manage.dto.response.RoomsResult;
import com.example.hotel_manage.entity.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomsRepository extends JpaRepository<Rooms,Long> {
    List<RoomsResult> findByAvailableTrue();

    Rooms getReferenceById(Class<? extends Long> aClass);
}

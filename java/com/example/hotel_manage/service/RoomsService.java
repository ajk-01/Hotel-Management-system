package com.example.hotel_manage.service;

import com.example.hotel_manage.dto.request.CreateRooms;
import com.example.hotel_manage.dto.response.RoomsResult;
import com.example.hotel_manage.entity.Rooms;

import java.time.LocalDate;
import java.util.List;

public interface RoomsService {
    List<RoomsResult> findAvailableRooms();
        List<RoomsResult> findAllRooms();

    List<RoomsResult> getRoomDetails(Long id);


    boolean isRoomAvailable(Long roomId, LocalDate startDate, LocalDate endDate);

    List<RoomsResult> createRoom(CreateRooms createRooms);

    List<RoomsResult> editRooms(Long id, Long room_no, String room_type, Boolean status, Long room_rate);


    List<RoomsResult> editRoomRate(Long id, Long room_rate);

    List<RoomsResult> editRoomsStatus(Long id, Boolean status);
}

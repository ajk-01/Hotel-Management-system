package com.example.hotel_manage.service.serviceimpl;

import com.example.hotel_manage.dto.request.CreateRooms;
import com.example.hotel_manage.dto.response.RoomsResult;
import com.example.hotel_manage.entity.Reservation;
import com.example.hotel_manage.entity.Rooms;
import com.example.hotel_manage.repository.ReservationRepository;
import com.example.hotel_manage.repository.RoomsRepository;
import com.example.hotel_manage.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RoomsServiceimpl implements RoomsService {
    @Autowired
    private RoomsRepository roomsRepository;
    @Autowired
    private ReservationRepository reservationRepository;
@Override
    public List<RoomsResult> findAvailableRooms()
{ List<RoomsResult> room= roomsRepository.findByAvailableTrue();
    return room;
}


    @Override
    public List<RoomsResult> findAllRooms() {
    return roomsRepository.findAll().stream()
            .map(rooms -> new RoomsResult(rooms.getId(), rooms.getRoom_type(), rooms.getStatus(), rooms.getRoom_no(), rooms.getRoom_rate()))
            .collect(Collectors.toList());
}

@Override
public List<RoomsResult> getRoomDetails(Long roomId)
{
    Optional<Rooms> rooms = roomsRepository.findById(roomId);
    return (List<RoomsResult>) rooms.orElse(null);
    }
    @Override
    public boolean isRoomAvailable(Long roomId, LocalDate startDate, LocalDate endDate) {

        Rooms room = roomsRepository.findById(roomId).orElse(null);
        if (room != null) {
            List<Reservation> reservations = reservationRepository.findRoomReservationsInDateRange(roomId, startDate, endDate);
            return reservations.isEmpty();
        }
        return false;
    }
    @Override
    public List<RoomsResult> createRoom(CreateRooms createRooms)
    {
        Rooms rooms=new Rooms();
        rooms.setRoom_no(createRooms.getRoom_no());
        rooms.setRoom_type(createRooms.getRoom_type());
        rooms.setStatus(createRooms.getStatus());
        rooms.setRoom_rate(createRooms.getRoom_rate());
        roomsRepository.save(rooms);
        return findAvailableRooms();
    }
    @Override
    public List<RoomsResult> editRooms(Long id, Long room_no, String room_type, Boolean status, Long room_rate)
    {
        Optional<Rooms> existingRoom=roomsRepository.findById(id);
        if(existingRoom.isPresent())
        {
            Rooms rooms = existingRoom.get();
            rooms.setRoom_no(room_no);
            rooms.setRoom_type(room_type);
            rooms.setStatus(status);
            rooms.setRoom_rate(room_rate);
            roomsRepository.save(rooms);
        }
        return findAllRooms();
    }
    @Override
    public List<RoomsResult> editRoomRate(Long id,  Long room_rate)
    {
        Optional<Rooms> existingRoom=roomsRepository.findById(id);
        if(existingRoom.isPresent())
        {
            Rooms rooms = existingRoom.get();
            rooms.setRoom_rate(room_rate);
            roomsRepository.save(rooms);
        }
        return findAllRooms();
    }
    @Override
    public List<RoomsResult> editRoomsStatus(Long id, Boolean status)
    {
        Optional<Rooms> existingRoom=roomsRepository.findById(id);
        if(existingRoom.isPresent())
        {
            Rooms rooms = existingRoom.get();
            rooms.setStatus(status);
            roomsRepository.save(rooms);
        }
        return findAllRooms();
    }

    }




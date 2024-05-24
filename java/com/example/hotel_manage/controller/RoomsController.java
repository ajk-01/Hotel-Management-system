package com.example.hotel_manage.controller;

import com.example.hotel_manage.dto.request.CreateRooms;
import com.example.hotel_manage.dto.response.RoomsResult;
import com.example.hotel_manage.service.RoomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomsController {
    @Autowired
    private RoomsService roomsService;
    @GetMapping("/get-available-rooms")
    public List<RoomsResult>getAllAvailableRooms()
    {
        return roomsService.findAvailableRooms();
    }
    @GetMapping("get-all-rooms")
   // information about hotel rooms should only be accesses by admin and manager
    @PreAuthorize("hasRole('admin') and hasRole('manager') and hasAuthority('Can_Access_admin')")
    public List<RoomsResult> getAllRooms()
    {
        return  roomsService.findAllRooms();
    }
@GetMapping("get-room-detail/{id}")
@PreAuthorize("hasRole('admin') and hasRole('manager') and hasAuthority('Can_Access_admin')")

    public List<RoomsResult> getRoomsDetails(@PathVariable("id") Long id)
{
    return roomsService.getRoomDetails(id);
}
@GetMapping("/is-room-available/{id}")
public boolean isRoomAvailable(@PathVariable("id")Long id, @RequestParam("startDate")LocalDate startDate,@RequestParam("endDate") LocalDate endDate)
{
    return roomsService.isRoomAvailable(id,startDate,endDate);

}
@PostMapping("/create-rooms")
@PreAuthorize("hasRole('admin')")
public List<RoomsResult> createRooms(@RequestBody CreateRooms createRooms)
{
    return roomsService.createRoom(createRooms);
}
@PutMapping("edit_rooms")
@PreAuthorize("hasRole('admin')")
    public List<RoomsResult> editRooms(@RequestParam("id") Long id,
                                       @RequestParam("room_no") Long room_no,
                                       @RequestParam("room_type") String room_type,@RequestParam("room_status")
                                       Boolean status,@RequestParam("room_rate") Long room_rate)
{
    return roomsService.editRooms(id, room_no, room_type, status, room_rate);
}
    @PutMapping("edit_room-rate")
    @PreAuthorize("hasRole('admin')")
    public List<RoomsResult> editRoomRates(@RequestParam("id") Long id,@RequestParam("room_rate") Long room_rate)
    {
     return roomsService.editRoomRate(id,room_rate);
    }
    @PutMapping("edit_room-status")
    @PreAuthorize("hasRole('admin') and hasRole('manager')")
    public List<RoomsResult> editRoomStatus(@RequestParam("id") Long id,@RequestParam("room_status") Boolean status)
    {
        return roomsService.editRoomsStatus(id,status);
    }
}

package com.example.hotel_manage.dto.response;

public class RoomsResult {
private Long id;
private String room_type;
private Boolean status;
private Long room_no;
private Long room_rate;

    public RoomsResult() {
    }

    public RoomsResult(Long id, String room_type, Boolean status, Long room_no, Long room_rate) {
        this.id = id;
        this.room_type = room_type;
        this.status = status;
        this.room_no = room_no;
        this.room_rate = room_rate;
    }

    public RoomsResult(String room_type, Boolean status, Long room_no,Long room_rate) {
        this.room_type = room_type;
        this.status = status;
        this.room_no = room_no;
        this.room_rate=room_rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getRoom_no() {
        return room_no;
    }

    public void setRoom_no(Long room_no) {
        this.room_no = room_no;
    }

    public Long getRoom_rate() {
        return room_rate;
    }

    public void setRoom_rate(Long room_rate) {
        this.room_rate = room_rate;
    }
}

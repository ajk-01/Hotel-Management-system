package com.example.hotel_manage.entity;

import com.example.hotel_manage.dto.response.RoomsResult;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@SpringBootApplication
@EntityScan("com.example.hotel_manage.entity")
@Entity
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long room_no;
    private Boolean status;
    private Long price;
    private String room_type;
    private Long room_rate;
    @ManyToOne
    @JsonIgnore
    private User users;
    @OneToMany(mappedBy = "rooms",cascade = CascadeType.ALL)
    private Set<Pay> pay;
    @OneToMany(mappedBy = "rooms")
    private Set<Reservation> reservationList;

    public Long getRoom_no() {
        return room_no;
    }

    public void setRoom_no(Long room_no) {
        this.room_no = room_no;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = Boolean.valueOf(status);
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public Set<User> getUsers() {
        return (Set<User>) users;
    }

    public void setUsers(Set<User> users) {
        this.users = (User) users;
    }

    public Rooms() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Long getRoom_rate() {
        return room_rate;
    }

    public void setRoom_rate(Long room_rate) {
        this.room_rate = room_rate;
    }
}

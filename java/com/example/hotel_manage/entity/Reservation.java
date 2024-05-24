package com.example.hotel_manage.entity;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDate;

@SpringBootApplication
@EntityScan("com.example.hotel_manage.entity")
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Rooms rooms;
    @ManyToOne
    @JoinColumn(name="Pay_id")
    private Pay pay;
    public Reservation() {
    }

    public Reservation(LocalDate startDate, LocalDate endDate, User user, Rooms rooms) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.rooms = rooms;
    }

    public Reservation(Long id, LocalDate startDate, LocalDate endDate, User user, Rooms rooms, Pay pay) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.rooms = rooms;
        this.pay = pay;
    }

    public Reservation(LocalDate startDate, LocalDate endDate, User user, Rooms rooms, Pay pay) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.user = user;
        this.rooms = rooms;
        this.pay = pay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rooms getRooms() {
        return rooms;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }
}

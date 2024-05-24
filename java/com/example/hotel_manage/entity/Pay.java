package com.example.hotel_manage.entity;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Set;
@SpringBootApplication
@EntityScan("com.example.hotel_manage.entity")
@Entity
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String payID;
    private Long pay;
    private Long sgst;
    private Long total_pay=pay+sgst;

@ManyToOne
@JoinColumn(name = "room_id")
private Rooms rooms;
@ManyToOne
@JoinColumn(name = "user_id")
private User user;
@OneToMany
private Set<Reservation> reservation;

    public Pay() {
    }

    public Pay(Long id, String payID, Long pay, Long sgst, Long total_pay, Rooms rooms, User user, Reservation reservation) {
        this.id = id;
        this.payID = payID;
        this.pay = pay;
        this.sgst = sgst;
        this.total_pay = total_pay;
        this.rooms = rooms;
        this.user = user;
        this.reservation = (Set<Reservation>) reservation;
    }

    public Pay(String payID, Long pay, Long sgst, Long total_pay, Rooms rooms, User user, Reservation reservation) {
        this.payID = payID;
        this.pay = pay;
        this.sgst = sgst;
        this.total_pay = total_pay;
        this.rooms = rooms;
        this.user = user;
        this.reservation = (Set<Reservation>) reservation;
    }

    public Pay(String payID, Long pay, Rooms rooms, User user, Reservation reservation) {
        this.payID = payID;
        this.pay = pay;
        this.rooms = rooms;
        this.user = user;
        this.reservation = (Set<Reservation>) reservation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }

    public Long getPay() {
        return pay;
    }

    public void setPay(Long pay) {
        this.pay = pay;
    }

    public Long getSgst() {
        return sgst;
    }

    public void setSgst(Long sgst) {
        this.sgst = sgst;
    }

    public Long getTotal_pay() {
        return total_pay;
    }

    public void setTotal_pay(Long total_pay) {
        this.total_pay = total_pay;
    }

    public Rooms getRooms() {
        return rooms;
    }
    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }


    public Reservation getReservation() {
        return (Reservation) reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = (Set<Reservation>) reservation;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

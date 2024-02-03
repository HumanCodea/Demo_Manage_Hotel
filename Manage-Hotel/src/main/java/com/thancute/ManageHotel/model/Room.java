package com.thancute.ManageHotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_room")
    private String nameRoom;
    private String typeRoom;
    private int numberPeople;
    private String dates;
    private String pricesRoom;

    public Room() {
    }

    public Room(String nameRoom, String typeRoom, int numberPeople, String dates, String pricesRoom) {
        this.nameRoom = nameRoom;
        this.typeRoom = typeRoom;
        this.numberPeople = numberPeople;
        this.dates = dates;
        this.pricesRoom = pricesRoom;
    }

    
    
}

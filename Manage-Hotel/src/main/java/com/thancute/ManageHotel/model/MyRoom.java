package com.thancute.ManageHotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MyRoom {

    @Id
    private int id;
    @Column(name = "name_room")
    private String nameRoom;
    private String typeRoom;
    private int numberPeople;
    private String dates;
    private String pricesRoom;

    public MyRoom() {
    }

    public MyRoom(int id, String nameRoom, String typeRoom, int numberPeople, String dates, String pricesRoom) {
        this.id = id;
        this.nameRoom = nameRoom;
        this.typeRoom = typeRoom;
        this.numberPeople = numberPeople;
        this.dates = dates;
        this.pricesRoom = pricesRoom;
    }

}

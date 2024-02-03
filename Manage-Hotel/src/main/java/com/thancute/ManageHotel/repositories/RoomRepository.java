package com.thancute.ManageHotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thancute.ManageHotel.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{

    @Query("Select c From Room c Where c.nameRoom Like %?1%")
    public List<Room> findRoomByName(String nameRoom);
    
}

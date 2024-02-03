package com.thancute.ManageHotel.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thancute.ManageHotel.model.MyRoom;

@Repository
public interface MyRoomRepository extends JpaRepository<MyRoom, Integer>{

    @Query("Select c From MyRoom c Where c.nameRoom Like %?1%")
    public List<MyRoom> findMyRoomByName(String nameRoom);
    
}

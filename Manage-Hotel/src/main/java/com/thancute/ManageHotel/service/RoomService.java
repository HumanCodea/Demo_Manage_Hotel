package com.thancute.ManageHotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thancute.ManageHotel.model.Room;
import com.thancute.ManageHotel.repositories.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;
    
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public void deleteRoom(int id){
        roomRepository.deleteById(id);
    }

    public void saveRoom(Room room){
        roomRepository.save(room);
    }

    public Room findRoomById(int id){
        return roomRepository.findById(id).get();
    }

    public List<Room> findRoomByName(String nameRoom){
        return roomRepository.findRoomByName(nameRoom);
    }

}

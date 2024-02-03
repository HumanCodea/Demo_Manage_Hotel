package com.thancute.ManageHotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thancute.ManageHotel.model.MyRoom;
import com.thancute.ManageHotel.repositories.MyRoomRepository;

@Service
public class MyRoomService {

    @Autowired
    private MyRoomRepository myRoomRepository;

    public List<MyRoom> getAllMyRoom(){
        return myRoomRepository.findAll();
    }
    
    public void saveMyRoom(MyRoom myRoom){
        myRoomRepository.save(myRoom);
    }

    public void deleteMyRoom(int id){
        myRoomRepository.deleteById(id);
    }

    public List<MyRoom> findMyRoomByName(String nameRoom){
        return myRoomRepository.findMyRoomByName(nameRoom);
    }
}

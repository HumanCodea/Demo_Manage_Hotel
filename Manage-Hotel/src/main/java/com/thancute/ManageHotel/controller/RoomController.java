package com.thancute.ManageHotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thancute.ManageHotel.model.MyRoom;
import com.thancute.ManageHotel.model.Room;
import com.thancute.ManageHotel.service.MyRoomService;
import com.thancute.ManageHotel.service.RoomService;

@Controller
@RequestMapping(path = "")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private MyRoomService myRoomService;
    
    @GetMapping("/home")
    public String HomeUser(){
        return "homeUser";
    }

    @GetMapping("/available_room")
    public String getAllRoom(Model model, @Param("nameRoom") String nameRoom){
        List<Room> list = roomService.getAllRooms();
        if(nameRoom != null){
            list = roomService.findRoomByName(nameRoom);
            model.addAttribute("nameRoom", nameRoom);
        }
        model.addAttribute("room", list);
        return "listRoom";
    }

    @GetMapping("/homeAdmin")
    public String HomeAdmin(){
        return "homeAdmin";
    }

    @PostMapping("/save")
    public String SaveRoom(@ModelAttribute Room room){
        roomService.saveRoom(room);
        return "redirect:/available_room";
    }

    @GetMapping("/room_register")
    public String RegisterRoom(){
        return "registerRoom";
    }

    @RequestMapping("/deleteList/{id}")
    public String DeleteRoom(@PathVariable("id") int id){
        roomService.deleteRoom(id);
        return "redirect:/available_room";
    }

    @RequestMapping("/editList/{id}")
    public String EditRoom(@PathVariable("id") int id, Model model){
        Room room = roomService.findRoomById(id);
        model.addAttribute("room", room);
        return "editRoom";
    }

    @RequestMapping("/mylist/{id}")
    public String AddToMyRoom(@PathVariable("id") int id){
        Room room = roomService.findRoomById(id);
        MyRoom myRoom = new MyRoom(room.getId(), room.getNameRoom(), room.getTypeRoom(), room.getNumberPeople(), room.getDates(), room.getPricesRoom());
        myRoomService.saveMyRoom(myRoom);
        return "redirect:/my_room";
    }

    @GetMapping("/search_room")
    public String getAllRooms(Model model, @Param("nameRoom") String nameRoom){
        List<Room> list = roomService.getAllRooms();
        if(nameRoom != null){
            list = roomService.findRoomByName(nameRoom);
            model.addAttribute("nameRoom", nameRoom);
        }
        model.addAttribute("room", list);
        return "searchRoom";
    }


}

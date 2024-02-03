package com.thancute.ManageHotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thancute.ManageHotel.model.MyRoom;
import com.thancute.ManageHotel.service.MyRoomService;

@Controller
public class MyRoomController {

    @Autowired
    private MyRoomService myRoomService;
    
    @GetMapping("/my_room")
    public String getAllMyRoom(Model model, @Param("nameRoom") String nameRoom){
        List<MyRoom> list = myRoomService.getAllMyRoom();
        if(nameRoom != null){
            list = myRoomService.findMyRoomByName(nameRoom);
            model.addAttribute("nameRoom", nameRoom);
        }
        model.addAttribute("room", list);
        return "myRoom";
    }

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyRoom(@PathVariable("id") int id){
        myRoomService.deleteMyRoom(id);
        return "redirect:/my_room";
    }

}

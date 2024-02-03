package com.thancute.ManageHotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thancute.ManageHotel.model.Custormer;
import com.thancute.ManageHotel.service.CustormerSerivice;

@Controller
@RequestMapping(path = "")
public class CustormerController {

    @Autowired
    private CustormerSerivice custormerSerivice;
    
    @GetMapping("/login")
    public String LoginUser(){
        return "loginUser";
    }

    @RequestMapping("/saveUser")
    public String SaveUser(@ModelAttribute Custormer custormer){
        custormerSerivice.SaveUser(custormer);
        return "redirect:/register?successfully";
    }

    @GetMapping("/register")
    public String RegisterUser(){
        return "registerUser";
    }

    @GetMapping("/logout")
    public String LogoutUser(){
        return "redirect:/login";
    }

}

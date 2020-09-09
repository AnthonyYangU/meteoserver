package com.example.demo.controllers;
//
//import com.example.demo.entity.AirportDetail;
//import com.example.demo.services.AirportDetailInterface;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AirportDetail;
import com.example.demo.services.AirportDetailInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AirportDetailController {
    @Autowired
    private AirportDetailInterface airportDetailInterface;

    @GetMapping("/airportDetail/{airport}")
    public AirportDetail getDetail(@PathVariable("airport") String airport) {

        AirportDetail airportDetail = airportDetailInterface.getAirportDetail(airport + ".json");
        return airportDetail;
    }
}

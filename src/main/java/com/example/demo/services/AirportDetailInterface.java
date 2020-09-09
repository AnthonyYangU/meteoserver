package com.example.demo.services;

import com.example.demo.entity.AirportDetail;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "${airportUrl}",name = "Detail")
public interface AirportDetailInterface {
//    @RequestMapping(value = "/json_data/simple/RKTN.json",method = RequestMethod.GET)
    @GetMapping("/json_data/simple/{airport}")
    AirportDetail getAirportDetail(@PathVariable("airport") String airport);


}


package com.example.demo.controllers;

import com.example.demo.entity.Airport;
import com.example.demo.entity.Meteo;
import com.example.demo.mapper.AirportMapper;
import com.example.demo.utils.CodeGenerator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AirportController {
    @Autowired
    private AirportMapper airportMapper;

    @PostMapping("/insertAirportInfo")
    public Airport insertAirportInfo(@RequestBody Airport airport){
        if(airportMapper.getByAirportCode(airport.getAirportCode())==null){
            airportMapper.insert(airport);

            return airport;
        }else{
            return null;
        }
    }

    @GetMapping("/getAirportById/{id}")
    public Airport getById(@PathVariable("id") long id){
        return airportMapper.getById(id);
    }

    @GetMapping("/getAirportByCode/{airportCode}")
    public Airport getByAirportCode(@PathVariable("airportCode") int airportCode){
        return airportMapper.getByAirportCode(airportCode);
    }

    @GetMapping("/getAirportByName/{airportName}")
    public Airport getByAirportName(@PathVariable("airportName") String airportName){
        return airportMapper.getByAirportName(airportName);
    }

    @GetMapping("/getAirport")
    public List<Airport> findAll(){
        return airportMapper.getAll();
    }

//    @GetMapping("/getAirportByImeiId/{imeiId}")
//    public List<Airport> getByImeiId(@PathVariable("imeiId") Integer imeiId){
//        return airportMapper.getByImeiId();
//    }

    @PostMapping("/updateAirportById")
    public Map<String,Integer> updateById(@RequestBody Airport airport) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(airport,airportMapper.getById(airport.getId()));
        airportMapper.updateById(airport);
        return Map.of("status",0);
    }

//    @PostMapping("/updateAirportByImeiAndSensorId")
//    public Map<String,String> updateByImeiAndSensorId(@RequestBody Airport airport) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        CodeGenerator.getSpecificUpdate(airport,airportMapper.getByImeiAndSensorId(airport.getImeiId(),airport.getSensorId()));
//        airportMapper.updateByImeiAndSensorId(airport);
//    }

    @PostMapping("/deleteAirportById")
    public Map<String,Integer> deleteById(@RequestBody long id){
        airportMapper.deleteById(id);
        return Map.of("status",0);
    }
}

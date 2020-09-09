package com.example.demo.controllers;

import com.example.demo.entity.Humitemp;
import com.example.demo.mapper.HumitempMapper;
import com.example.demo.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HumitempController {
    @Autowired
    private HumitempMapper humitempMapper;

    @PostMapping("/insertHumitempInfo")
    public Humitemp insertHumitempInfo(@RequestBody Humitemp humitemp){
        if(humitempMapper.getByAirportCode(humitemp.getAirportCode())==null){
            humitempMapper.insert(humitemp);
            return humitemp;
        }else{
            return null;
        }
    }

    @GetMapping("/getHumitempById/{id}")
    public Humitemp getById(@PathVariable("id") long id){
        return humitempMapper.getById(id);
    }

    @GetMapping("/getHumitempByName/{airportName}")
    public List<Humitemp> getByAirportName(@PathVariable("airportName") String airportName){
        return humitempMapper.getByAirportName(airportName);
    }

    @GetMapping("/getHumitempByImeiId/{imeiId}")
    public List<Humitemp> getByImeiId(@PathVariable("imeiId") Integer imeiId){
        return humitempMapper.getByImeiId(imeiId);
    }

    @GetMapping("/getHumitemp")
    public List<Humitemp> findAll(){
        return humitempMapper.getAll();
    }

    @PostMapping("/updateHumitempById")
    public Map<String,Integer> updateById(@RequestBody Humitemp humitemp) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(humitemp,humitempMapper.getById(humitemp.getId()));
        humitempMapper.updateById(humitemp);
        return Map.of("status",0);
    }

    @PostMapping("/updateHumitempByImeiAndSensorId")
    public Map<String,Integer> updateByImeiAndSensorId(@RequestBody Humitemp humitemp) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(humitemp,humitempMapper.getByImeiAndSensorId(humitemp.getImeiId(),humitemp.getSensorId()));
        humitempMapper.updateByImeiAndSensorId(humitemp);
        return Map.of("status",0);
    }

    @PostMapping("/deleteHumitempById")
    public Map<String,Integer> deleteById(@RequestBody long id){
        humitempMapper.deleteById(id);
        return Map.of("status",0);
    }
}

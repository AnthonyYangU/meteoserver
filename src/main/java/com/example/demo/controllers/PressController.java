package com.example.demo.controllers;

import com.example.demo.entity.Press;
import com.example.demo.mapper.PressMapper;
import com.example.demo.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PressController {
    @Autowired
    private PressMapper pressMapper;

    @PostMapping("/insertPressInfo")
    public Press insertPressInfo(@RequestBody Press press){
        if(pressMapper.getByAirportCode(press.getAirportCode())==null){
            pressMapper.insert(press);
            return press;
        }else{
            return null;
        }
    }

    @GetMapping("/getPressById/{id}")
    public Press getById(@PathVariable("id") long id){
        return pressMapper.getById(id);
    }

    @GetMapping("/getPressByName/{airportName}")
    public List<Press> getByAirportName(@PathVariable("airportName") String airportName){
        return pressMapper.getByAirportName(airportName);
    }

    @GetMapping("/getPressByImeiId/{imeiId}")
    public List<Press> getByImeiId(@PathVariable("imeiId") Integer imeiId){
        return pressMapper.getByImeiId(imeiId);
    }

    @GetMapping("/getPress")
    public List<Press> findAll(){
        return pressMapper.getAll();
    }

    @PostMapping("/updatePressById")
    public Map<String,Integer> updateById(@RequestBody Press press) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(press,pressMapper.getById(press.getId()));
        pressMapper.updateById(press);
        return Map.of("status",0);
    }

    @PostMapping("/updatePressByImeiAndSensorId")
    public Map<String,Integer> updateByImeiAndSensorId(@RequestBody Press press) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(press,pressMapper.getByImeiAndSensorId(press.getImeiId(),press.getSensorId()));
        pressMapper.updateByImeiAndSensorId(press);
        return Map.of("status",0);
    }

    @PostMapping("/deletePressById")
    public Map<String,Integer> deleteById(@RequestBody long id){
        pressMapper.deleteById(id);
        return Map.of("status",0);
    }
}

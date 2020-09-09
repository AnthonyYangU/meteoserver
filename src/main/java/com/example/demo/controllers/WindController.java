package com.example.demo.controllers;

import com.example.demo.entity.Wind;
import com.example.demo.mapper.WindMapper;
import com.example.demo.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WindController {
    @Autowired
    private WindMapper windMapper;

    @PostMapping("/insertWindInfo")
    public Wind insertWindInfo(@RequestBody Wind wind){
        if(windMapper.getByAirportCode(wind.getAirportCode())==null){
            windMapper.insert(wind);
            return wind;
        }else{
            return null;
        }
    }

    @GetMapping("/getWindById/{id}")
    public Wind getById(@PathVariable("id") long id){
        return windMapper.getById(id);
    }

    @GetMapping("/getWindByName/{airportName}")
    public List<Wind> getByAirportName(@PathVariable("airportName") String airportName){
        return windMapper.getByAirportName(airportName);
    }

    @GetMapping("/getWindByImeiId/{imeiId}")
    public List<Wind> getByImeiId(@PathVariable("imeiId") Integer imeiId){
        return windMapper.getByImeiId(imeiId);
    }

    @GetMapping("/getWind")
    public List<Wind> findAll(){
        return windMapper.getAll();
    }

    @PostMapping("/updateWindById")
    public Map<String,Integer> updateById(@RequestBody Wind wind) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(wind,windMapper.getById(wind.getId()));
        windMapper.updateById(wind);
        return Map.of("status",0);
    }

    @PostMapping("/updateWindByImeiAndSensorId")
    public Map<String,Integer> updateByImeiAndSensorId(@RequestBody Wind wind) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(wind,windMapper.getByImeiAndSensorId(wind.getImeiId(),wind.getSensorId()));
        windMapper.updateByImeiAndSensorId(wind);
        return Map.of("status",0);
    }

    @PostMapping("/deleteWindById")
    public Map<String,Integer> deleteById(@RequestBody long id){
        windMapper.deleteById(id);
        return Map.of("status",0);
    }
}

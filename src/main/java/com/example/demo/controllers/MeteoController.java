package com.example.demo.controllers;

import com.example.demo.entity.Meteo;
import com.example.demo.mapper.MeteoMapper;
import com.example.demo.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MeteoController {
    @Autowired
    private MeteoMapper meteoMapper;

    @PostMapping("/insertMeteoInfo")
    public Meteo insertMeteoInfo(@RequestBody Meteo meteo){
        if(meteoMapper.getByAirportCode(meteo.getAirportCode())==null){
            meteoMapper.insert(meteo);
            return meteo;
        }else{
            return null;
        }
    }

    @GetMapping("/getMeteoById/{id}")
    public Meteo getById(@PathVariable("id") long id){
        return meteoMapper.getById(id);
    }

    @GetMapping("/getMeteoByName/{airportName}")
    public List<Meteo> getByAirportName(@PathVariable("airportName") String airportName){
        return meteoMapper.getByAirportName(airportName);
    }

    @GetMapping("/getMeteoByImeiId/{imeiId}")
    public List<Meteo> getByImeiId(@PathVariable("imeiId") Integer imeiId){
        return meteoMapper.getByImeiId(imeiId);
    }

    @GetMapping("/getMeteo")
    public List<Meteo> findAll(){
        return meteoMapper.getAll();
    }

    @PostMapping("/updateMeteoById")
    public Map<String,Integer> updateById(@RequestBody Meteo meteo) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(meteo,meteoMapper.getById(meteo.getId()));
        meteoMapper.updateById(meteo);
        return Map.of("status",0);
    }

    @PostMapping("/updateMeteoByImeiAndSensorId")
    public Map<String,Integer> updateByImeiAndSensorId(@RequestBody Meteo meteo) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(meteo,meteoMapper.getByImeiAndSensorId(meteo.getImeiId(),meteo.getSensorId()));
        meteoMapper.updateByImeiAndSensorId(meteo);
        return Map.of("status",0);
    }

    @PostMapping("/deleteMeteoById")
    public Map<String,Integer> deleteById(@RequestBody long id){
        meteoMapper.deleteById(id);
        return Map.of("status",0);
    }
}

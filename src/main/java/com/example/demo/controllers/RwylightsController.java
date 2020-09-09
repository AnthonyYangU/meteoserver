package com.example.demo.controllers;

import com.example.demo.entity.Rwylights;
import com.example.demo.mapper.RwylightsMapper;
import com.example.demo.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RwylightsController {
    @Autowired
    private RwylightsMapper rwylightsMapper;

    @PostMapping("/insertRwylightsInfo")
    public Rwylights insertRwylightsInfo(@RequestBody Rwylights rwylights){
        if(rwylightsMapper.getByAirportCode(rwylights.getAirportCode())==null){
            rwylightsMapper.insert(rwylights);
            return rwylights;
        }else{
            return null;
        }
    }

    @GetMapping("/getRwylightsById/{id}")
    public Rwylights getById(@PathVariable("id") long id){
        return rwylightsMapper.getById(id);
    }

    @GetMapping("/getRwylightsByName/{airportName}")
    public List<Rwylights> getByAirportName(@PathVariable("airportName") String airportName){
        return rwylightsMapper.getByAirportName(airportName);
    }

    @GetMapping("/getRwylightsByImeiId/{imeiId}")
    public List<Rwylights> getByImeiId(@PathVariable("imeiId") Integer imeiId){
        return rwylightsMapper.getByImeiId(imeiId);
    }

    @GetMapping("/getRwylights")
    public List<Rwylights> findAll(){
        return rwylightsMapper.getAll();
    }

    @PostMapping("/updateRwylightsById")
    public Map<String,Integer> updateById(@RequestBody Rwylights rwylights) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(rwylights,rwylightsMapper.getById(rwylights.getId()));
        rwylightsMapper.updateById(rwylights);
        return Map.of("status",0);
    }

    @PostMapping("/updateRwylightsByImeiAndSensorId")
    public Map<String,Integer> updateByImeiAndSensorId(@RequestBody Rwylights rwylights) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(rwylights,rwylightsMapper.getByImeiAndSensorId(rwylights.getImeiId(),rwylights.getSensorId()));
        rwylightsMapper.updateByImeiAndSensorId(rwylights);
        return Map.of("status",0);
    }

    @PostMapping("/deleteRwylightsById")
    public Map<String,Integer> deleteById(@RequestBody long id){
        rwylightsMapper.deleteById(id);
        return Map.of("status",0);
    }
}

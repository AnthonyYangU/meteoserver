package com.example.demo.controllers;

import com.example.demo.entity.Vis;
import com.example.demo.mapper.VisMapper;
import com.example.demo.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class VisController {
    @Autowired
    private VisMapper visMapper;

    @PostMapping("/insertVisInfo")
    public Vis insertVisInfo(@RequestBody Vis vis){
        if(visMapper.getByAirportCode(vis.getAirportCode())==null){
            visMapper.insert(vis);
            return vis;
        }else{
            return null;
        }
    }

    @GetMapping("/getVisById/{id}")
    public Vis getById(@PathVariable("id") long id){
        return visMapper.getById(id);
    }

    @GetMapping("/getVisByName/{airportName}")
    public List<Vis> getByAirportName(@PathVariable("airportName") String airportName){
        return visMapper.getByAirportName(airportName);
    }

    @GetMapping("/getVisByImeiId/{imeiId}")
    public List<Vis> getByImeiId(@PathVariable("imeiId") Integer imeiId){
        return visMapper.getByImeiId(imeiId);
    }

    @GetMapping("/getVis")
    public List<Vis> findAll(){
        return visMapper.getAll();
    }

    @PostMapping("/updateVisById")
    public Map<String,Integer> updateById(@RequestBody Vis vis) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(vis,visMapper.getById(vis.getId()));
        visMapper.updateById(vis);
        return Map.of("status",0);
    }

    @PostMapping("/updateVisByImeiAndSensorId")
    public Map<String,Integer> updateByImeiAndSensorId(@RequestBody Vis vis) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(vis,visMapper.getByImeiAndSensorId(vis.getImeiId(),vis.getSensorId()));
        visMapper.updateByImeiAndSensorId(vis);
        return Map.of("status",0);
    }

    @PostMapping("/deleteVisById")
    public Map<String,Integer> deleteById(@RequestBody long id){
        visMapper.deleteById(id);
        return Map.of("status",0);
    }
}

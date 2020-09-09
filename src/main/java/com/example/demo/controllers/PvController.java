package com.example.demo.controllers;

import com.example.demo.entity.Pv;
import com.example.demo.mapper.PvMapper;
import com.example.demo.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PvController {
    @Autowired
    private PvMapper pvMapper;

    @PostMapping("/insertPvInfo")
    public Pv insertPvInfo(@RequestBody Pv pv){
        if(pvMapper.getByAirportCode(pv.getAirportCode())==null){
            pvMapper.insert(pv);
            return pv;
        }else{
            return null;
        }
    }

    @GetMapping("/getPvById/{id}")
    public Pv getById(@PathVariable("id") long id){
        return pvMapper.getById(id);
    }

    @GetMapping("/getPvByName/{airportName}")
    public List<Pv> getByAirportName(@PathVariable("airportName") String airportName){
        return pvMapper.getByAirportName(airportName);
    }

    @GetMapping("/getPvByImeiId/{imeiId}")
    public List<Pv> getByImeiId(@PathVariable("imeiId") Integer imeiId){
        return pvMapper.getByImeiId(imeiId);
    }

    @GetMapping("/getPv")
    public List<Pv> findAll(){
        return pvMapper.getAll();
    }

    @PostMapping("/updatePvById")
    public Map<String,Integer> updateById(@RequestBody Pv pv) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(pv,pvMapper.getById(pv.getId()));
        pvMapper.updateById(pv);
        return Map.of("status",0);
    }

    @PostMapping("/updatePvByImeiAndSensorId")
    public Map<String,Integer> updateByImeiAndSensorId(@RequestBody Pv pv) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(pv,pvMapper.getByImeiAndSensorId(pv.getImeiId(),pv.getSensorId()));
        pvMapper.updateByImeiAndSensorId(pv);
        return Map.of("status",0);
    }

    @PostMapping("/deletePvById")
    public Map<String,Integer> deleteById(@RequestBody long id){
        pvMapper.deleteById(id);
        return Map.of("status",0);
    }
}

package com.example.demo.controllers;

import com.example.demo.entity.Rosa;
import com.example.demo.mapper.RosaMapper;
import com.example.demo.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RosaController {
    @Autowired
    private RosaMapper rosaMapper;

    @PostMapping("/insertRosaInfo")
    public Rosa insertRosaInfo(@RequestBody Rosa rosa){
        if(rosaMapper.getByAirportCode(rosa.getAirportCode())==null){
            rosaMapper.insert(rosa);
            return rosa;
        }else{
            return null;
        }
    }

    @GetMapping("/getRosaById/{id}")
    public Rosa getById(@PathVariable("id") long id){
        return rosaMapper.getById(id);
    }

    @GetMapping("/getRosaByName/{airportName}")
    public List<Rosa> getByAirportName(@PathVariable("airportName") String airportName){
        return rosaMapper.getByAirportName(airportName);
    }

    @GetMapping("/getRosaByImeiId/{imeiId}")
    public List<Rosa> getByImeiId(@PathVariable("imeiId") Integer imeiId){
        return rosaMapper.getByImeiId(imeiId);
    }

    @GetMapping("/getRosa")
    public List<Rosa> findAll(){
        return rosaMapper.getAll();
    }

    @PostMapping("/updateRosaById")
    public Map<String,Integer> updateById(@RequestBody Rosa rosa) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(rosa,rosaMapper.getById(rosa.getId()));
        rosaMapper.updateById(rosa);
        return Map.of("status",0);
    }

    @PostMapping("/updateRosaByImeiAndSensorId")
    public Map<String,Integer> updateByImeiAndSensorId(@RequestBody Rosa rosa) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(rosa,rosaMapper.getByImeiAndSensorId(rosa.getImeiId(),rosa.getSensorId()));
        rosaMapper.updateByImeiAndSensorId(rosa);
        return Map.of("status",0);
    }

    @PostMapping("/deleteRosaById")
    public Map<String,Integer> deleteById(@RequestBody long id){
        rosaMapper.deleteById(id);
        return Map.of("status",0);
    }
}

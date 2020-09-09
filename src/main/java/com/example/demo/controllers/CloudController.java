package com.example.demo.controllers;

import com.example.demo.entity.Cloud;
import com.example.demo.mapper.CloudMapper;
import com.example.demo.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CloudController {
    @Autowired
    private CloudMapper cloudMapper;

    @PostMapping("/insertCloudInfo")
    public Cloud insertCloudInfo(@RequestBody Cloud cloud){
        if(cloudMapper.getByAirportCode(cloud.getAirportCode())==null){
            cloudMapper.insert(cloud);
            return cloud;
        }else{
            return null;
        }
    }

    @GetMapping("/getCloudById/{id}")
    public Cloud getById(@PathVariable("id") long id){
        return cloudMapper.getById(id);
    }

    @GetMapping("/getCloudByName/{airportName}")
    public List<Cloud> getByAirportName(@PathVariable("airportName") String airportName){
        return cloudMapper.getByAirportName(airportName);
    }

    @GetMapping("/getCloudByImeiId/{imeiId}")
    public List<Cloud> getByImeiId(@PathVariable("imeiId") Integer imeiId){
        return cloudMapper.getByImeiId(imeiId);
    }

    @GetMapping("/getCloud")
    public List<Cloud> findAll(){
        return cloudMapper.getAll();
    }

    @PostMapping("/updateCloudById")
    public Map<String,Integer> updateById(@RequestBody Cloud cloud) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(cloud,cloudMapper.getById(cloud.getId()));
        cloudMapper.updateById(cloud);
        return Map.of("status",0);
    }

    @PostMapping("/updateCloudByImeiAndSensorId")
    public Map<String,Integer> updateByImeiAndSensorId(@RequestBody Cloud cloud) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(cloud,cloudMapper.getByImeiAndSensorId(cloud.getImeiId(),cloud.getSensorId()));
        cloudMapper.updateByImeiAndSensorId(cloud);
        return Map.of("status",0);
    }

    @PostMapping("/deleteCloudById")
    public Map<String,Integer> deleteById(@RequestBody long id){
        cloudMapper.deleteById(id);
        return Map.of("status",0);
    }
}

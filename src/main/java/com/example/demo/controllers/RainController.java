package com.example.demo.controllers;

import com.example.demo.entity.Rain;
import com.example.demo.mapper.RainMapper;
import com.example.demo.utils.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RainController {
    @Autowired
    private RainMapper rainMapper;

    @PostMapping("/insertRainInfo")
    public Rain insertRainInfo(@RequestBody Rain rain){
        if(rainMapper.getByAirportCode(rain.getAirportCode())==null){
            rainMapper.insert(rain);
            return rain;
        }else{
            return null;
        }
    }

    @GetMapping("/getRainById/{id}")
    public Rain getById(@PathVariable("id") long id){
        return rainMapper.getById(id);
    }

    @GetMapping("/getRainByName/{airportName}")
    public List<Rain> getByAirportName(@PathVariable("airportName") String airportName){
        return rainMapper.getByAirportName(airportName);
    }

    @GetMapping("/getRainByImeiId/{imeiId}")
    public List<Rain> getByImeiId(@PathVariable("imeiId") Integer imeiId){
        return rainMapper.getByImeiId(imeiId);
    }

    @GetMapping("/getRain")
    public List<Rain> findAll(){
        return rainMapper.getAll();
    }

    @PostMapping("/updateRainById")
    public Map<String,Integer> updateById(@RequestBody Rain rain) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(rain,rainMapper.getById(rain.getId()));
        rainMapper.updateById(rain);
        return Map.of("status",0);
    }

    @PostMapping("/updateRainByImeiAndSensorId")
    public Map<String,Integer> updateByImeiAndSensorId(@RequestBody Rain rain) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        CodeGenerator.getSpecificUpdate(rain,rainMapper.getByImeiAndSensorId(rain.getImeiId(),rain.getSensorId()));
        rainMapper.updateByImeiAndSensorId(rain);
        return Map.of("status",0);
    }

    @PostMapping("/deleteRainById")
    public Map<String,Integer> deleteById(@RequestBody long id){
        rainMapper.deleteById(id);
        return Map.of("status",0);
    }
}

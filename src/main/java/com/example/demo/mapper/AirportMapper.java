package com.example.demo.mapper;

import com.example.demo.entity.Airport;
import com.example.demo.entity.Meteo;
import jdk.jfr.Registered;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AirportMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into airports(airportCode,airportName,latitude,longitude) values(#{airport.airportCode},#{airport.airportName},#{airport.latttude},#{airport.longitude})")
    void insert(@Param("airport") Airport airport);

    @Select("select * from airports where id=#{id}")
    Airport getById(@Param("id") Long id);

    @Select("select * from airports where airportCode=#{airportCode}")
    Airport getByAirportCode(@Param("airportCode") Integer airportCode);

    @Select("select * from airports where airportName=#{airportName}")
    Airport getByAirportName(@Param("airportName") String airportName);

    @Select("select * from airports")
    List<Airport> getAll();

    @Update("update airports set airportName=#{airport.airportName},latitude=#{airport.latitude},longitude=#{airport.longitude}")
    void updateByAirportCode(@Param("airport") Airport airport);

    @Update("update airports set airportCode=#{airport.airportCode},latitude=#{airport.latitude},longitude=#{airport.longitude}")
    void updateByAirportName(@Param("airport") Airport airport);

    @Update("update airports set airportCode=#{airport.airportCode},airportName=#{airport.airportName},latitude=#{airport.latitude},longitude=#{airport.longitude}")
    void updateById(@Param("airport") Airport airport);

    @Delete("delete from airports where airportCode=#{airportCode}")
    void deleteByAirportCode(@Param("airportCode") Integer airportCode);

    @Delete("delete from airports where airportName=#{airportName}")
    void deleteByAirportName(@Param("airportName") Integer airportName);

    @Delete("delete from airports where id=#{id}")
    void deleteById(@Param("id") long id);
}

package com.example.demo.mapper;

import com.example.demo.entity.Meteo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MeteoMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into meteos(time,imeiId,airportCode,airportName,version,sequenceNumber,messageTime,messageType,sensorId,locationId) values(#{meteo.time},#{meteo.imeiId},#{meteo.airportCode},#{meteo.airportName},#{meteo.version},#{meteo.sequenceNumber},#{meteo.messageTime},#{meteo.messageType},#{meteo.sensorId},#{meteo.locationId})")
    void insert(@Param("meteo") Meteo meteo);

    @Select("select * from meteos where id=#{id}")
    Meteo getById(@Param("id") Long id);

    @Select("select * from meteos where airportCode=#{airportCode}")
    List<Meteo> getByAirportCode(@Param("airportCode") Integer airportCode);

    @Select("select * from meteos where airportName=#{airportName}")
    List<Meteo> getByAirportName(@Param("airportName") String airportName);

    @Select("select * from meteos where imeiId=#{imeiId}")
    List<Meteo> getByImeiId(@Param("imeiId") Integer imeiId);

    @Select("select * from meteos where imeiId=#{imeiId} and sensorId=#{sensorId}")
    Meteo getByImeiAndSensorId(@Param("imeiId") Integer imeiId, @Param("sensorId") Integer sensorId);

    @Select("select * from meteos")
    List<Meteo> getAll();

    @Update("update meteos set time= #{meteo.time},imeiId= #{meteo.imeiId},airportName= #{meteo.airportName},version= #{meteo.version},sequenceNumber= #{meteo.sequenceNumber},messageTime= #{meteo.messageTime},messageType= #{meteo.messageType},sensorId= #{meteo.sensorId},locationId= #{meteo.locationId} where airportCode=#{meteo.airportCode}")
    void updateByAirportCode(@Param("meteo") Meteo meteo);

    @Update("update meteos set time= #{meteo.time},imeiId= #{meteo.imeiId},airportCode= #{meteo.airportCode},version= #{meteo.version},sequenceNumber= #{meteo.sequenceNumber},messageTime= #{meteo.messageTime},messageType= #{meteo.messageType},sensorId= #{meteo.sensorId},locationId= #{meteo.locationId} where airportName=#{meteo.airportName}")
    void updateByAirportName(@Param("meteo") Meteo meteo);

    @Update("update meteos set time= #{meteo.time},imeiId= #{meteo.imeiId},airportCode= #{meteo.airportCode},airportName= #{meteo.airportName},version= #{meteo.version},sequenceNumber= #{meteo.sequenceNumber},messageTime= #{meteo.messageTime},messageType= #{meteo.messageType},sensorId= #{meteo.sensorId},locationId= #{meteo.locationId} where id=#{meteo.id}")
    void updateById(@Param("meteo") Meteo meteo);

    @Update("update meteos set time= #{meteo.time},airportCode= #{meteo.airportCode},airportName= #{meteo.airportName},version= #{meteo.version},sequenceNumber= #{meteo.sequenceNumber},messageTime= #{meteo.messageTime},messageType= #{meteo.messageType},sensorId= #{meteo.sensorId},locationId= #{meteo.locationId} where imeiId=#{meteo.imeiId}")
    void updateByImeiId(@Param("meteo") Meteo meteo);

    @Update("update meteos set time= #{meteo.time},airportCode= #{meteo.airportCode},airportName= #{meteo.airportName},version= #{meteo.version},sequenceNumber= #{meteo.sequenceNumber},messageTime= #{meteo.messageTime},messageType= #{meteo.messageType},sensorId= #{meteo.sensorId},locationId= #{meteo.locationId} where imeiId=#{meteo.imeiId} and sensorId=#{meteo.sensorId}")
    void updateByImeiAndSensorId(@Param("meteo") Meteo meteo);

    @Delete("delete from meteos where airportCode=#{airportCode}")
    void deleteByAirportCode(@Param("airportCode") Integer airportCode);

    @Delete("delete from meteos where airportName=#{airportName}")
    void deleteByAirportName(@Param("airportName") Integer airportName);

    @Delete("delete from meteos where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Delete("delete from meteos where imeiId=#{imeiId}")
    void deleteByImeiId(@Param("imeiId") Integer imeiId);

}
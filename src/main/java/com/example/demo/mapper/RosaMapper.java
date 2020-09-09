package com.example.demo.mapper;

import com.example.demo.entity.Rosa;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RosaMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into rosas(time,imeiId,airportCode,airportName,version,sequenceNumber,messageTime,messageType,sensorId,locationId,stemp,gstemp,surfsta,alarm_status,rain_status,surface_status) values(#{rosa.time},#{rosa.imeiId},#{rosa.airportCode},#{rosa.airportName},#{rosa.version},#{rosa.sequenceNumber},#{rosa.messageTime},#{rosa.messageType},#{rosa.sensorId},#{rosa.locationId},#{rosa.stemp},#{rosa.gstemp},#{rosa.surfsta},#{rosa.alarm_status},#{rosa.rain_status},#{rosa.surface_status})")
    void insert(@Param("rosa") Rosa rosa);

    @Select("select * from rosas where id=#{id}")
    Rosa getById(@Param("id") Long id);

    @Select("select * from rosas where airportCode=#{airportCode}")
    List<Rosa> getByAirportCode(@Param("airportCode") Integer airportCode);

    @Select("select * from rosas where airportName=#{airportName}")
    List<Rosa> getByAirportName(@Param("airportName") String airportName);

    @Select("select * from rosas where imeiId=#{imeiId}")
    List<Rosa> getByImeiId(@Param("imeiId") Integer imeiId);

    @Select("select * from rosas where imeiId=#{imeiId} and sensorId=#{sensorId}")
    Rosa getByImeiAndSensorId(@Param("imeiId") Integer imeiId, @Param("sensorId") Integer sensorId);

    @Select("select * from rosas")
    List<Rosa> getAll();

    @Update("update rosas set time= #{rosa.time},imeiId= #{rosa.imeiId},airportName= #{rosa.airportName},version= #{rosa.version},sequenceNumber= #{rosa.sequenceNumber},messageTime= #{rosa.messageTime},messageType= #{rosa.messageType},sensorId= #{rosa.sensorId},locationId= #{rosa.locationId},stemp= #{rosa.stemp},gstemp= #{rosa.gstemp},surfsta= #{rosa.surfsta},alarm_status= #{rosa.alarm_status},rain_status= #{rosa.rain_status},surface_status= #{rosa.surface_status} where airportCode=#{rosa.airportCode}")
    void updateByAirportCode(@Param("rosa") Rosa rosa);

    @Update("update rosas set time= #{rosa.time},imeiId= #{rosa.imeiId},airportCode= #{rosa.airportCode},version= #{rosa.version},sequenceNumber= #{rosa.sequenceNumber},messageTime= #{rosa.messageTime},messageType= #{rosa.messageType},sensorId= #{rosa.sensorId},locationId= #{rosa.locationId},stemp= #{rosa.stemp},gstemp= #{rosa.gstemp},surfsta= #{rosa.surfsta},alarm_status= #{rosa.alarm_status},rain_status= #{rosa.rain_status},surface_status= #{rosa.surface_status} where airportName=#{rosa.airportName}")
    void updateByAirportName(@Param("rosa") Rosa rosa);

    @Update("update rosas set time= #{rosa.time},imeiId= #{rosa.imeiId},airportCode= #{rosa.airportCode},airportName= #{rosa.airportName},version= #{rosa.version},sequenceNumber= #{rosa.sequenceNumber},messageTime= #{rosa.messageTime},messageType= #{rosa.messageType},sensorId= #{rosa.sensorId},locationId= #{rosa.locationId},stemp= #{rosa.stemp},gstemp= #{rosa.gstemp},surfsta= #{rosa.surfsta},alarm_status= #{rosa.alarm_status},rain_status= #{rosa.rain_status},surface_status= #{rosa.surface_status} where id=#{rosa.id}")
    void updateById(@Param("rosa") Rosa rosa);

    @Update("update rosas set time= #{rosa.time},airportCode= #{rosa.airportCode},airportName= #{rosa.airportName},version= #{rosa.version},sequenceNumber= #{rosa.sequenceNumber},messageTime= #{rosa.messageTime},messageType= #{rosa.messageType},sensorId= #{rosa.sensorId},locationId= #{rosa.locationId},stemp= #{rosa.stemp},gstemp= #{rosa.gstemp},surfsta= #{rosa.surfsta},alarm_status= #{rosa.alarm_status},rain_status= #{rosa.rain_status},surface_status= #{rosa.surface_status} where imeiId=#{rosa.imeiId}")
    void updateByImeiId(@Param("rosa") Rosa rosa);

    @Update("update rosas set time= #{rosa.time},airportCode= #{rosa.airportCode},airportName= #{rosa.airportName},version= #{rosa.version},sequenceNumber= #{rosa.sequenceNumber},messageTime= #{rosa.messageTime},messageType= #{rosa.messageType},sensorId= #{rosa.sensorId},locationId= #{rosa.locationId},stemp= #{rosa.stemp},gstemp= #{rosa.gstemp},surfsta= #{rosa.surfsta},alarm_status= #{rosa.alarm_status},rain_status= #{rosa.rain_status},surface_status= #{rosa.surface_status} where imeiId=#{rosa.imeiId} and sensorId=#{rosa.sensorId}")
    void updateByImeiAndSensorId(@Param("rosa") Rosa rosa);

    @Delete("delete from rosas where airportCode=#{airportCode}")
    void deleteByAirportCode(@Param("airportCode") Integer airportCode);

    @Delete("delete from rosas where airportName=#{airportName}")
    void deleteByAirportName(@Param("airportName") Integer airportName);

    @Delete("delete from rosas where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Delete("delete from rosas where imeiId=#{imeiId}")
    void deleteByImeiId(@Param("imeiId") Integer imeiId);

}
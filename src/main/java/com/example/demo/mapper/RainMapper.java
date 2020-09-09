package com.example.demo.mapper;

import com.example.demo.entity.Rain;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RainMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into rains(time,imeiId,airportCode,airportName,version,sequenceNumber,messageTime,messageType,sensorId,locationId,rainon,amount_ins,sum_ins,duration_1h,sum_1h) values(#{rain.time},#{rain.imeiId},#{rain.airportCode},#{rain.airportName},#{rain.version},#{rain.sequenceNumber},#{rain.messageTime},#{rain.messageType},#{rain.sensorId},#{rain.locationId},#{rain.rainon},#{rain.amount_ins},#{rain.sum_ins},#{rain.duration_1h},#{rain.sum_1h})")
    void insert(@Param("rain") Rain rain);

    @Select("select * from rains where id=#{id}")
    Rain getById(@Param("id") Long id);

    @Select("select * from rains where airportCode=#{airportCode}")
    List<Rain> getByAirportCode(@Param("airportCode") Integer airportCode);

    @Select("select * from rains where airportName=#{airportName}")
    List<Rain> getByAirportName(@Param("airportName") String airportName);

    @Select("select * from rains where imeiId=#{imeiId}")
    List<Rain> getByImeiId(@Param("imeiId") Integer imeiId);

    @Select("select * from rains where imeiId=#{imeiId} and sensorId=#{sensorId}")
    Rain getByImeiAndSensorId(@Param("imeiId") Integer imeiId, @Param("sensorId") Integer sensorId);

    @Select("select * from rains")
    List<Rain> getAll();

    @Update("update rains set time= #{rain.time},imeiId= #{rain.imeiId},airportName= #{rain.airportName},version= #{rain.version},sequenceNumber= #{rain.sequenceNumber},messageTime= #{rain.messageTime},messageType= #{rain.messageType},sensorId= #{rain.sensorId},locationId= #{rain.locationId},rainon= #{rain.rainon},amount_ins= #{rain.amount_ins},sum_ins= #{rain.sum_ins},duration_1h= #{rain.duration_1h},sum_1h= #{rain.sum_1h} where airportCode=#{rain.airportCode}")
    void updateByAirportCode(@Param("rain") Rain rain);

    @Update("update rains set time= #{rain.time},imeiId= #{rain.imeiId},airportCode= #{rain.airportCode},version= #{rain.version},sequenceNumber= #{rain.sequenceNumber},messageTime= #{rain.messageTime},messageType= #{rain.messageType},sensorId= #{rain.sensorId},locationId= #{rain.locationId},rainon= #{rain.rainon},amount_ins= #{rain.amount_ins},sum_ins= #{rain.sum_ins},duration_1h= #{rain.duration_1h},sum_1h= #{rain.sum_1h} where airportName=#{rain.airportName}")
    void updateByAirportName(@Param("rain") Rain rain);

    @Update("update rains set time= #{rain.time},imeiId= #{rain.imeiId},airportCode= #{rain.airportCode},airportName= #{rain.airportName},version= #{rain.version},sequenceNumber= #{rain.sequenceNumber},messageTime= #{rain.messageTime},messageType= #{rain.messageType},sensorId= #{rain.sensorId},locationId= #{rain.locationId},rainon= #{rain.rainon},amount_ins= #{rain.amount_ins},sum_ins= #{rain.sum_ins},duration_1h= #{rain.duration_1h},sum_1h= #{rain.sum_1h} where id=#{rain.id}")
    void updateById(@Param("rain") Rain rain);

    @Update("update rains set time= #{rain.time},airportCode= #{rain.airportCode},airportName= #{rain.airportName},version= #{rain.version},sequenceNumber= #{rain.sequenceNumber},messageTime= #{rain.messageTime},messageType= #{rain.messageType},sensorId= #{rain.sensorId},locationId= #{rain.locationId},rainon= #{rain.rainon},amount_ins= #{rain.amount_ins},sum_ins= #{rain.sum_ins},duration_1h= #{rain.duration_1h},sum_1h= #{rain.sum_1h} where imeiId=#{rain.imeiId}")
    void updateByImeiId(@Param("rain") Rain rain);

    @Update("update rains set time= #{rain.time},airportCode= #{rain.airportCode},airportName= #{rain.airportName},version= #{rain.version},sequenceNumber= #{rain.sequenceNumber},messageTime= #{rain.messageTime},messageType= #{rain.messageType},sensorId= #{rain.sensorId},locationId= #{rain.locationId},rainon= #{rain.rainon},amount_ins= #{rain.amount_ins},sum_ins= #{rain.sum_ins},duration_1h= #{rain.duration_1h},sum_1h= #{rain.sum_1h} where imeiId=#{rain.imeiId} and sensorId=#{rain.sensorId}")
    void updateByImeiAndSensorId(@Param("rain") Rain rain);

    @Delete("delete from rains where airportCode=#{airportCode}")
    void deleteByAirportCode(@Param("airportCode") Integer airportCode);

    @Delete("delete from rains where airportName=#{airportName}")
    void deleteByAirportName(@Param("airportName") Integer airportName);

    @Delete("delete from rains where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Delete("delete from rains where imeiId=#{imeiId}")
    void deleteByImeiId(@Param("imeiId") Integer imeiId);

}
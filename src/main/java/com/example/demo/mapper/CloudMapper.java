package com.example.demo.mapper;

import com.example.demo.entity.Cloud;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CloudMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into clouds(time,imeiId,airportCode,airportName,version,sequenceNumber,messageTime,messageType,sensorId,locationId,isskyclear,isvervis,vervis,cloudbase,ch1ins,ch2ins,amount1,ch1,amount2,ch2,amount3,ch3,amount4,ch4) values(#{cloud.time},#{cloud.imeiId},#{cloud.airportCode},#{cloud.airportName},#{cloud.version},#{cloud.sequenceNumber},#{cloud.messageTime},#{cloud.messageType},#{cloud.sensorId},#{cloud.locationId},#{cloud.isskyclear},#{cloud.isvervis},#{cloud.vervis},#{cloud.cloudbase},#{cloud.ch1ins},#{cloud.ch2ins},#{cloud.amount1},#{cloud.ch1},#{cloud.amount2},#{cloud.ch2},#{cloud.amount3},#{cloud.ch3},#{cloud.amount4},#{cloud.ch4})")
    void insert(@Param("cloud") Cloud cloud);

    @Select("select * from clouds where id=#{id}")
    Cloud getById(@Param("id") Long id);

    @Select("select * from clouds where airportCode=#{airportCode}")
    List<Cloud> getByAirportCode(@Param("airportCode") Integer airportCode);

    @Select("select * from clouds where airportName=#{airportName}")
    List<Cloud> getByAirportName(@Param("airportName") String airportName);

    @Select("select * from clouds where imeiId=#{imeiId}")
    List<Cloud> getByImeiId(@Param("imeiId") Integer imeiId);

    @Select("select * from clouds where imeiId=#{imeiId} and sensorId=#{sensorId}")
    Cloud getByImeiAndSensorId(@Param("imeiId") Integer imeiId, @Param("sensorId") Integer sensorId);

    @Select("select * from clouds")
    List<Cloud> getAll();

    @Update("update clouds set time= #{cloud.time},imeiId= #{cloud.imeiId},airportName= #{cloud.airportName},version= #{cloud.version},sequenceNumber= #{cloud.sequenceNumber},messageTime= #{cloud.messageTime},messageType= #{cloud.messageType},sensorId= #{cloud.sensorId},locationId= #{cloud.locationId},isskyclear= #{cloud.isskyclear},isvervis= #{cloud.isvervis},vervis= #{cloud.vervis},cloudbase= #{cloud.cloudbase},ch1ins= #{cloud.ch1ins},ch2ins= #{cloud.ch2ins},amount1= #{cloud.amount1},ch1= #{cloud.ch1},amount2= #{cloud.amount2},ch2= #{cloud.ch2},amount3= #{cloud.amount3},ch3= #{cloud.ch3},amount4= #{cloud.amount4},ch4= #{cloud.ch4} where airportCode=#{cloud.airportCode}")
    void updateByAirportCode(@Param("cloud") Cloud cloud);

    @Update("update clouds set time= #{cloud.time},imeiId= #{cloud.imeiId},airportCode= #{cloud.airportCode},version= #{cloud.version},sequenceNumber= #{cloud.sequenceNumber},messageTime= #{cloud.messageTime},messageType= #{cloud.messageType},sensorId= #{cloud.sensorId},locationId= #{cloud.locationId},isskyclear= #{cloud.isskyclear},isvervis= #{cloud.isvervis},vervis= #{cloud.vervis},cloudbase= #{cloud.cloudbase},ch1ins= #{cloud.ch1ins},ch2ins= #{cloud.ch2ins},amount1= #{cloud.amount1},ch1= #{cloud.ch1},amount2= #{cloud.amount2},ch2= #{cloud.ch2},amount3= #{cloud.amount3},ch3= #{cloud.ch3},amount4= #{cloud.amount4},ch4= #{cloud.ch4} where airportName=#{cloud.airportName}")
    void updateByAirportName(@Param("cloud") Cloud cloud);

    @Update("update clouds set time= #{cloud.time},imeiId= #{cloud.imeiId},airportCode= #{cloud.airportCode},airportName= #{cloud.airportName},version= #{cloud.version},sequenceNumber= #{cloud.sequenceNumber},messageTime= #{cloud.messageTime},messageType= #{cloud.messageType},sensorId= #{cloud.sensorId},locationId= #{cloud.locationId},isskyclear= #{cloud.isskyclear},isvervis= #{cloud.isvervis},vervis= #{cloud.vervis},cloudbase= #{cloud.cloudbase},ch1ins= #{cloud.ch1ins},ch2ins= #{cloud.ch2ins},amount1= #{cloud.amount1},ch1= #{cloud.ch1},amount2= #{cloud.amount2},ch2= #{cloud.ch2},amount3= #{cloud.amount3},ch3= #{cloud.ch3},amount4= #{cloud.amount4},ch4= #{cloud.ch4} where id=#{cloud.id}")
    void updateById(@Param("cloud") Cloud cloud);

    @Update("update clouds set time= #{cloud.time},airportCode= #{cloud.airportCode},airportName= #{cloud.airportName},version= #{cloud.version},sequenceNumber= #{cloud.sequenceNumber},messageTime= #{cloud.messageTime},messageType= #{cloud.messageType},sensorId= #{cloud.sensorId},locationId= #{cloud.locationId},isskyclear= #{cloud.isskyclear},isvervis= #{cloud.isvervis},vervis= #{cloud.vervis},cloudbase= #{cloud.cloudbase},ch1ins= #{cloud.ch1ins},ch2ins= #{cloud.ch2ins},amount1= #{cloud.amount1},ch1= #{cloud.ch1},amount2= #{cloud.amount2},ch2= #{cloud.ch2},amount3= #{cloud.amount3},ch3= #{cloud.ch3},amount4= #{cloud.amount4},ch4= #{cloud.ch4} where imeiId=#{cloud.imeiId}")
    void updateByImeiId(@Param("cloud") Cloud cloud);

    @Update("update clouds set time= #{cloud.time},airportCode= #{cloud.airportCode},airportName= #{cloud.airportName},version= #{cloud.version},sequenceNumber= #{cloud.sequenceNumber},messageTime= #{cloud.messageTime},messageType= #{cloud.messageType},sensorId= #{cloud.sensorId},locationId= #{cloud.locationId},isskyclear= #{cloud.isskyclear},isvervis= #{cloud.isvervis},vervis= #{cloud.vervis},cloudbase= #{cloud.cloudbase},ch1ins= #{cloud.ch1ins},ch2ins= #{cloud.ch2ins},amount1= #{cloud.amount1},ch1= #{cloud.ch1},amount2= #{cloud.amount2},ch2= #{cloud.ch2},amount3= #{cloud.amount3},ch3= #{cloud.ch3},amount4= #{cloud.amount4},ch4= #{cloud.ch4} where imeiId=#{cloud.imeiId} and sensorId=#{cloud.sensorId}")
    void updateByImeiAndSensorId(@Param("cloud") Cloud cloud);

    @Delete("delete from clouds where airportCode=#{airportCode}")
    void deleteByAirportCode(@Param("airportCode") Integer airportCode);

    @Delete("delete from clouds where airportName=#{airportName}")
    void deleteByAirportName(@Param("airportName") Integer airportName);

    @Delete("delete from clouds where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Delete("delete from clouds where imeiId=#{imeiId}")
    void deleteByImeiId(@Param("imeiId") Integer imeiId);

}
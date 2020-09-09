package com.example.demo.mapper;

import com.example.demo.entity.Humitemp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HumitempMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into humitemps(time,imeiId,airportCode,airportName,version,sequenceNumber,messageTime,messageType,sensorId,locationId,tains,tdins,rhins,vpins,ta10m,ta1x,ta1ha,ta1hx) values(#{humitemp.time},#{humitemp.imeiId},#{humitemp.airportCode},#{humitemp.airportName},#{humitemp.version},#{humitemp.sequenceNumber},#{humitemp.messageTime},#{humitemp.messageType},#{humitemp.sensorId},#{humitemp.locationId},#{humitemp.tains},#{humitemp.tdins},#{humitemp.rhins},#{humitemp.vpins},#{humitemp.ta10m},#{humitemp.ta1x},#{humitemp.ta1ha},#{humitemp.ta1hx})")
    void insert(@Param("humitemp") Humitemp humitemp);

    @Select("select * from humitemps where id=#{id}")
    Humitemp getById(@Param("id") Long id);

    @Select("select * from humitemps where airportCode=#{airportCode}")
    List<Humitemp> getByAirportCode(@Param("airportCode") Integer airportCode);

    @Select("select * from humitemps where airportName=#{airportName}")
    List<Humitemp> getByAirportName(@Param("airportName") String airportName);

    @Select("select * from humitemps where imeiId=#{imeiId}")
    List<Humitemp> getByImeiId(@Param("imeiId") Integer imeiId);

    @Select("select * from humitemps where imeiId=#{imeiId} and sensorId=#{sensorId}")
    Humitemp getByImeiAndSensorId(@Param("imeiId") Integer imeiId, @Param("sensorId") Integer sensorId);

    @Select("select * from humitemps")
    List<Humitemp> getAll();

    @Update("update humitemps set time= #{humitemp.time},imeiId= #{humitemp.imeiId},airportName= #{humitemp.airportName},version= #{humitemp.version},sequenceNumber= #{humitemp.sequenceNumber},messageTime= #{humitemp.messageTime},messageType= #{humitemp.messageType},sensorId= #{humitemp.sensorId},locationId= #{humitemp.locationId},tains= #{humitemp.tains},tdins= #{humitemp.tdins},rhins= #{humitemp.rhins},vpins= #{humitemp.vpins},ta10m= #{humitemp.ta10m},ta1x= #{humitemp.ta1x},ta1ha= #{humitemp.ta1ha},ta1hx= #{humitemp.ta1hx} where airportCode=#{humitemp.airportCode}")
    void updateByAirportCode(@Param("humitemp") Humitemp humitemp);

    @Update("update humitemps set time= #{humitemp.time},imeiId= #{humitemp.imeiId},airportCode= #{humitemp.airportCode},version= #{humitemp.version},sequenceNumber= #{humitemp.sequenceNumber},messageTime= #{humitemp.messageTime},messageType= #{humitemp.messageType},sensorId= #{humitemp.sensorId},locationId= #{humitemp.locationId},tains= #{humitemp.tains},tdins= #{humitemp.tdins},rhins= #{humitemp.rhins},vpins= #{humitemp.vpins},ta10m= #{humitemp.ta10m},ta1x= #{humitemp.ta1x},ta1ha= #{humitemp.ta1ha},ta1hx= #{humitemp.ta1hx} where airportName=#{humitemp.airportName}")
    void updateByAirportName(@Param("humitemp") Humitemp humitemp);

    @Update("update humitemps set time= #{humitemp.time},imeiId= #{humitemp.imeiId},airportCode= #{humitemp.airportCode},airportName= #{humitemp.airportName},version= #{humitemp.version},sequenceNumber= #{humitemp.sequenceNumber},messageTime= #{humitemp.messageTime},messageType= #{humitemp.messageType},sensorId= #{humitemp.sensorId},locationId= #{humitemp.locationId},tains= #{humitemp.tains},tdins= #{humitemp.tdins},rhins= #{humitemp.rhins},vpins= #{humitemp.vpins},ta10m= #{humitemp.ta10m},ta1x= #{humitemp.ta1x},ta1ha= #{humitemp.ta1ha},ta1hx= #{humitemp.ta1hx} where id=#{humitemp.id}")
    void updateById(@Param("humitemp") Humitemp humitemp);

    @Update("update humitemps set time= #{humitemp.time},airportCode= #{humitemp.airportCode},airportName= #{humitemp.airportName},version= #{humitemp.version},sequenceNumber= #{humitemp.sequenceNumber},messageTime= #{humitemp.messageTime},messageType= #{humitemp.messageType},sensorId= #{humitemp.sensorId},locationId= #{humitemp.locationId},tains= #{humitemp.tains},tdins= #{humitemp.tdins},rhins= #{humitemp.rhins},vpins= #{humitemp.vpins},ta10m= #{humitemp.ta10m},ta1x= #{humitemp.ta1x},ta1ha= #{humitemp.ta1ha},ta1hx= #{humitemp.ta1hx} where imeiId=#{humitemp.imeiId}")
    void updateByImeiId(@Param("humitemp") Humitemp humitemp);

    @Update("update humitemps set time= #{humitemp.time},airportCode= #{humitemp.airportCode},airportName= #{humitemp.airportName},version= #{humitemp.version},sequenceNumber= #{humitemp.sequenceNumber},messageTime= #{humitemp.messageTime},messageType= #{humitemp.messageType},sensorId= #{humitemp.sensorId},locationId= #{humitemp.locationId},tains= #{humitemp.tains},tdins= #{humitemp.tdins},rhins= #{humitemp.rhins},vpins= #{humitemp.vpins},ta10m= #{humitemp.ta10m},ta1x= #{humitemp.ta1x},ta1ha= #{humitemp.ta1ha},ta1hx= #{humitemp.ta1hx} where imeiId=#{humitemp.imeiId} and sensorId=#{humitemp.sensorId}")
    void updateByImeiAndSensorId(@Param("humitemp") Humitemp humitemp);

    @Delete("delete from humitemps where airportCode=#{airportCode}")
    void deleteByAirportCode(@Param("airportCode") Integer airportCode);

    @Delete("delete from humitemps where airportName=#{airportName}")
    void deleteByAirportName(@Param("airportName") Integer airportName);

    @Delete("delete from humitemps where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Delete("delete from humitemps where imeiId=#{imeiId}")
    void deleteByImeiId(@Param("imeiId") Integer imeiId);

}
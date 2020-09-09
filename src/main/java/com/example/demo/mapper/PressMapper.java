package com.example.demo.mapper;

import com.example.demo.entity.Press;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PressMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into presss(time,imeiId,airportCode,airportName,version,sequenceNumber,messageTime,messageType,sensorId,locationId,pains,qfe,qff,qnh,qfem,qfex,qfesynop,qfesynopt,qfesynop3h,fl,alt) values(#{press.time},#{press.imeiId},#{press.airportCode},#{press.airportName},#{press.version},#{press.sequenceNumber},#{press.messageTime},#{press.messageType},#{press.sensorId},#{press.locationId},#{press.pains},#{press.qfe},#{press.qff},#{press.qnh},#{press.qfem},#{press.qfex},#{press.qfesynop},#{press.qfesynopt},#{press.qfesynop3h},#{press.fl},#{press.alt})")
    void insert(@Param("press") Press press);

    @Select("select * from presss where id=#{id}")
    Press getById(@Param("id") Long id);

    @Select("select * from presss where airportCode=#{airportCode}")
    List<Press> getByAirportCode(@Param("airportCode") Integer airportCode);

    @Select("select * from presss where airportName=#{airportName}")
    List<Press> getByAirportName(@Param("airportName") String airportName);

    @Select("select * from presss where imeiId=#{imeiId}")
    List<Press> getByImeiId(@Param("imeiId") Integer imeiId);

    @Select("select * from presss where imeiId=#{imeiId} and sensorId=#{sensorId}")
    Press getByImeiAndSensorId(@Param("imeiId") Integer imeiId, @Param("sensorId") Integer sensorId);

    @Select("select * from presss")
    List<Press> getAll();

    @Update("update presss set time= #{press.time},imeiId= #{press.imeiId},airportName= #{press.airportName},version= #{press.version},sequenceNumber= #{press.sequenceNumber},messageTime= #{press.messageTime},messageType= #{press.messageType},sensorId= #{press.sensorId},locationId= #{press.locationId},pains= #{press.pains},qfe= #{press.qfe},qff= #{press.qff},qnh= #{press.qnh},qfem= #{press.qfem},qfex= #{press.qfex},qfesynop= #{press.qfesynop},qfesynopt= #{press.qfesynopt},qfesynop3h= #{press.qfesynop3h},fl= #{press.fl},alt= #{press.alt} where airportCode=#{press.airportCode}")
    void updateByAirportCode(@Param("press") Press press);

    @Update("update presss set time= #{press.time},imeiId= #{press.imeiId},airportCode= #{press.airportCode},version= #{press.version},sequenceNumber= #{press.sequenceNumber},messageTime= #{press.messageTime},messageType= #{press.messageType},sensorId= #{press.sensorId},locationId= #{press.locationId},pains= #{press.pains},qfe= #{press.qfe},qff= #{press.qff},qnh= #{press.qnh},qfem= #{press.qfem},qfex= #{press.qfex},qfesynop= #{press.qfesynop},qfesynopt= #{press.qfesynopt},qfesynop3h= #{press.qfesynop3h},fl= #{press.fl},alt= #{press.alt} where airportName=#{press.airportName}")
    void updateByAirportName(@Param("press") Press press);

    @Update("update presss set time= #{press.time},imeiId= #{press.imeiId},airportCode= #{press.airportCode},airportName= #{press.airportName},version= #{press.version},sequenceNumber= #{press.sequenceNumber},messageTime= #{press.messageTime},messageType= #{press.messageType},sensorId= #{press.sensorId},locationId= #{press.locationId},pains= #{press.pains},qfe= #{press.qfe},qff= #{press.qff},qnh= #{press.qnh},qfem= #{press.qfem},qfex= #{press.qfex},qfesynop= #{press.qfesynop},qfesynopt= #{press.qfesynopt},qfesynop3h= #{press.qfesynop3h},fl= #{press.fl},alt= #{press.alt} where id=#{press.id}")
    void updateById(@Param("press") Press press);

    @Update("update presss set time= #{press.time},airportCode= #{press.airportCode},airportName= #{press.airportName},version= #{press.version},sequenceNumber= #{press.sequenceNumber},messageTime= #{press.messageTime},messageType= #{press.messageType},sensorId= #{press.sensorId},locationId= #{press.locationId},pains= #{press.pains},qfe= #{press.qfe},qff= #{press.qff},qnh= #{press.qnh},qfem= #{press.qfem},qfex= #{press.qfex},qfesynop= #{press.qfesynop},qfesynopt= #{press.qfesynopt},qfesynop3h= #{press.qfesynop3h},fl= #{press.fl},alt= #{press.alt} where imeiId=#{press.imeiId}")
    void updateByImeiId(@Param("press") Press press);

    @Update("update presss set time= #{press.time},airportCode= #{press.airportCode},airportName= #{press.airportName},version= #{press.version},sequenceNumber= #{press.sequenceNumber},messageTime= #{press.messageTime},messageType= #{press.messageType},sensorId= #{press.sensorId},locationId= #{press.locationId},pains= #{press.pains},qfe= #{press.qfe},qff= #{press.qff},qnh= #{press.qnh},qfem= #{press.qfem},qfex= #{press.qfex},qfesynop= #{press.qfesynop},qfesynopt= #{press.qfesynopt},qfesynop3h= #{press.qfesynop3h},fl= #{press.fl},alt= #{press.alt} where imeiId=#{press.imeiId} and sensorId=#{press.sensorId}")
    void updateByImeiAndSensorId(@Param("press") Press press);

    @Delete("delete from presss where airportCode=#{airportCode}")
    void deleteByAirportCode(@Param("airportCode") Integer airportCode);

    @Delete("delete from presss where airportName=#{airportName}")
    void deleteByAirportName(@Param("airportName") Integer airportName);

    @Delete("delete from presss where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Delete("delete from presss where imeiId=#{imeiId}")
    void deleteByImeiId(@Param("imeiId") Integer imeiId);

}
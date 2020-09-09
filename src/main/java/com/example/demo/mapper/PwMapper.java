package com.example.demo.mapper;

import com.example.demo.entity.Pw;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PwMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into pws(time,imeiId,airportCode,airportName,version,sequenceNumber,messageTime,messageType,sensorId,locationId,pw,rw,wxnws,wmoins,wmo15a,wmo60a,prw1a,prws,prss,tbins) values(#{pw.time},#{pw.imeiId},#{pw.airportCode},#{pw.airportName},#{pw.version},#{pw.sequenceNumber},#{pw.messageTime},#{pw.messageType},#{pw.sensorId},#{pw.locationId},#{pw.pw},#{pw.rw},#{pw.wxnws},#{pw.wmoins},#{pw.wmo15a},#{pw.wmo60a},#{pw.prw1a},#{pw.prws},#{pw.prss},#{pw.tbins})")
    void insert(@Param("pw") Pw pw);

    @Select("select * from pws where id=#{id}")
    Pw getById(@Param("id") Long id);

    @Select("select * from pws where airportCode=#{airportCode}")
    List<Pw> getByAirportCode(@Param("airportCode") Integer airportCode);

    @Select("select * from pws where airportName=#{airportName}")
    List<Pw> getByAirportName(@Param("airportName") String airportName);

    @Select("select * from pws where imeiId=#{imeiId}")
    List<Pw> getByImeiId(@Param("imeiId") Integer imeiId);

    @Select("select * from pws where imeiId=#{imeiId} and sensorId=#{sensorId}")
    Pw getByImeiAndSensorId(@Param("imeiId") Integer imeiId, @Param("sensorId") Integer sensorId);

    @Select("select * from pws")
    List<Pw> getAll();

    @Update("update pws set time= #{pw.time},imeiId= #{pw.imeiId},airportName= #{pw.airportName},version= #{pw.version},sequenceNumber= #{pw.sequenceNumber},messageTime= #{pw.messageTime},messageType= #{pw.messageType},sensorId= #{pw.sensorId},locationId= #{pw.locationId},pw= #{pw.pw},rw= #{pw.rw},wxnws= #{pw.wxnws},wmoins= #{pw.wmoins},wmo15a= #{pw.wmo15a},wmo60a= #{pw.wmo60a},prw1a= #{pw.prw1a},prws= #{pw.prws},prss= #{pw.prss},tbins= #{pw.tbins} where airportCode=#{pw.airportCode}")
    void updateByAirportCode(@Param("pw") Pw pw);

    @Update("update pws set time= #{pw.time},imeiId= #{pw.imeiId},airportCode= #{pw.airportCode},version= #{pw.version},sequenceNumber= #{pw.sequenceNumber},messageTime= #{pw.messageTime},messageType= #{pw.messageType},sensorId= #{pw.sensorId},locationId= #{pw.locationId},pw= #{pw.pw},rw= #{pw.rw},wxnws= #{pw.wxnws},wmoins= #{pw.wmoins},wmo15a= #{pw.wmo15a},wmo60a= #{pw.wmo60a},prw1a= #{pw.prw1a},prws= #{pw.prws},prss= #{pw.prss},tbins= #{pw.tbins} where airportName=#{pw.airportName}")
    void updateByAirportName(@Param("pw") Pw pw);

    @Update("update pws set time= #{pw.time},imeiId= #{pw.imeiId},airportCode= #{pw.airportCode},airportName= #{pw.airportName},version= #{pw.version},sequenceNumber= #{pw.sequenceNumber},messageTime= #{pw.messageTime},messageType= #{pw.messageType},sensorId= #{pw.sensorId},locationId= #{pw.locationId},pw= #{pw.pw},rw= #{pw.rw},wxnws= #{pw.wxnws},wmoins= #{pw.wmoins},wmo15a= #{pw.wmo15a},wmo60a= #{pw.wmo60a},prw1a= #{pw.prw1a},prws= #{pw.prws},prss= #{pw.prss},tbins= #{pw.tbins} where id=#{pw.id}")
    void updateById(@Param("pw") Pw pw);

    @Update("update pws set time= #{pw.time},airportCode= #{pw.airportCode},airportName= #{pw.airportName},version= #{pw.version},sequenceNumber= #{pw.sequenceNumber},messageTime= #{pw.messageTime},messageType= #{pw.messageType},sensorId= #{pw.sensorId},locationId= #{pw.locationId},pw= #{pw.pw},rw= #{pw.rw},wxnws= #{pw.wxnws},wmoins= #{pw.wmoins},wmo15a= #{pw.wmo15a},wmo60a= #{pw.wmo60a},prw1a= #{pw.prw1a},prws= #{pw.prws},prss= #{pw.prss},tbins= #{pw.tbins} where imeiId=#{pw.imeiId}")
    void updateByImeiId(@Param("pw") Pw pw);

    @Update("update pws set time= #{pw.time},airportCode= #{pw.airportCode},airportName= #{pw.airportName},version= #{pw.version},sequenceNumber= #{pw.sequenceNumber},messageTime= #{pw.messageTime},messageType= #{pw.messageType},sensorId= #{pw.sensorId},locationId= #{pw.locationId},pw= #{pw.pw},rw= #{pw.rw},wxnws= #{pw.wxnws},wmoins= #{pw.wmoins},wmo15a= #{pw.wmo15a},wmo60a= #{pw.wmo60a},prw1a= #{pw.prw1a},prws= #{pw.prws},prss= #{pw.prss},tbins= #{pw.tbins} where imeiId=#{pw.imeiId} and sensorId=#{pw.sensorId}")
    void updateByImeiAndSensorId(@Param("pw") Pw pw);

    @Delete("delete from pws where airportCode=#{airportCode}")
    void deleteByAirportCode(@Param("airportCode") Integer airportCode);

    @Delete("delete from pws where airportName=#{airportName}")
    void deleteByAirportName(@Param("airportName") Integer airportName);

    @Delete("delete from pws where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Delete("delete from pws where imeiId=#{imeiId}")
    void deleteByImeiId(@Param("imeiId") Integer imeiId);

}
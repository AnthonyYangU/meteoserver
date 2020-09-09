package com.example.demo.mapper;

import com.example.demo.entity.Wind;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WindMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into winds(time,imeiId,airportCode,airportName,version,sequenceNumber,messageTime,messageType,sensorId,locationId,wsins,wdins,ws2a,ws2m,ws2x,wd2a,wd2m,wd2x,ws10a,ws10m,ws10x,wd10a,wd10m,wd10x,hw2a,cw2a,cw2a_kt_str,cw2a_mps_str) values(#{wind.time},#{wind.imeiId},#{wind.airportCode},#{wind.airportName},#{wind.version},#{wind.sequenceNumber},#{wind.messageTime},#{wind.messageType},#{wind.sensorId},#{wind.locationId},#{wind.wsins},#{wind.wdins},#{wind.ws2a},#{wind.ws2m},#{wind.ws2x},#{wind.wd2a},#{wind.wd2m},#{wind.wd2x},#{wind.ws10a},#{wind.ws10m},#{wind.ws10x},#{wind.wd10a},#{wind.wd10m},#{wind.wd10x},#{wind.hw2a},#{wind.cw2a},#{wind.cw2a_kt_str},#{wind.cw2a_mps_str})")
    void insert(@Param("wind") Wind wind);

    @Select("select * from winds where id=#{id}")
    Wind getById(@Param("id") Long id);

    @Select("select * from winds where airportCode=#{airportCode}")
    List<Wind> getByAirportCode(@Param("airportCode") Integer airportCode);

    @Select("select * from winds where airportName=#{airportName}")
    List<Wind> getByAirportName(@Param("airportName") String airportName);

    @Select("select * from winds where imeiId=#{imeiId}")
    List<Wind> getByImeiId(@Param("imeiId") Integer imeiId);

    @Select("select * from winds where imeiId=#{imeiId} and sensorId=#{sensorId}")
    Wind getByImeiAndSensorId(@Param("imeiId") Integer imeiId, @Param("sensorId") Integer sensorId);

    @Select("select * from winds")
    List<Wind> getAll();

    @Update("update winds set time= #{wind.time},imeiId= #{wind.imeiId},airportName= #{wind.airportName},version= #{wind.version},sequenceNumber= #{wind.sequenceNumber},messageTime= #{wind.messageTime},messageType= #{wind.messageType},sensorId= #{wind.sensorId},locationId= #{wind.locationId},wsins= #{wind.wsins},wdins= #{wind.wdins},ws2a= #{wind.ws2a},ws2m= #{wind.ws2m},ws2x= #{wind.ws2x},wd2a= #{wind.wd2a},wd2m= #{wind.wd2m},wd2x= #{wind.wd2x},ws10a= #{wind.ws10a},ws10m= #{wind.ws10m},ws10x= #{wind.ws10x},wd10a= #{wind.wd10a},wd10m= #{wind.wd10m},wd10x= #{wind.wd10x},hw2a= #{wind.hw2a},cw2a= #{wind.cw2a},cw2a_kt_str= #{wind.cw2a_kt_str},cw2a_mps_str= #{wind.cw2a_mps_str} where airportCode=#{wind.airportCode}")
    void updateByAirportCode(@Param("wind") Wind wind);

    @Update("update winds set time= #{wind.time},imeiId= #{wind.imeiId},airportCode= #{wind.airportCode},version= #{wind.version},sequenceNumber= #{wind.sequenceNumber},messageTime= #{wind.messageTime},messageType= #{wind.messageType},sensorId= #{wind.sensorId},locationId= #{wind.locationId},wsins= #{wind.wsins},wdins= #{wind.wdins},ws2a= #{wind.ws2a},ws2m= #{wind.ws2m},ws2x= #{wind.ws2x},wd2a= #{wind.wd2a},wd2m= #{wind.wd2m},wd2x= #{wind.wd2x},ws10a= #{wind.ws10a},ws10m= #{wind.ws10m},ws10x= #{wind.ws10x},wd10a= #{wind.wd10a},wd10m= #{wind.wd10m},wd10x= #{wind.wd10x},hw2a= #{wind.hw2a},cw2a= #{wind.cw2a},cw2a_kt_str= #{wind.cw2a_kt_str},cw2a_mps_str= #{wind.cw2a_mps_str} where airportName=#{wind.airportName}")
    void updateByAirportName(@Param("wind") Wind wind);

    @Update("update winds set time= #{wind.time},imeiId= #{wind.imeiId},airportCode= #{wind.airportCode},airportName= #{wind.airportName},version= #{wind.version},sequenceNumber= #{wind.sequenceNumber},messageTime= #{wind.messageTime},messageType= #{wind.messageType},sensorId= #{wind.sensorId},locationId= #{wind.locationId},wsins= #{wind.wsins},wdins= #{wind.wdins},ws2a= #{wind.ws2a},ws2m= #{wind.ws2m},ws2x= #{wind.ws2x},wd2a= #{wind.wd2a},wd2m= #{wind.wd2m},wd2x= #{wind.wd2x},ws10a= #{wind.ws10a},ws10m= #{wind.ws10m},ws10x= #{wind.ws10x},wd10a= #{wind.wd10a},wd10m= #{wind.wd10m},wd10x= #{wind.wd10x},hw2a= #{wind.hw2a},cw2a= #{wind.cw2a},cw2a_kt_str= #{wind.cw2a_kt_str},cw2a_mps_str= #{wind.cw2a_mps_str} where id=#{wind.id}")
    void updateById(@Param("wind") Wind wind);

    @Update("update winds set time= #{wind.time},airportCode= #{wind.airportCode},airportName= #{wind.airportName},version= #{wind.version},sequenceNumber= #{wind.sequenceNumber},messageTime= #{wind.messageTime},messageType= #{wind.messageType},sensorId= #{wind.sensorId},locationId= #{wind.locationId},wsins= #{wind.wsins},wdins= #{wind.wdins},ws2a= #{wind.ws2a},ws2m= #{wind.ws2m},ws2x= #{wind.ws2x},wd2a= #{wind.wd2a},wd2m= #{wind.wd2m},wd2x= #{wind.wd2x},ws10a= #{wind.ws10a},ws10m= #{wind.ws10m},ws10x= #{wind.ws10x},wd10a= #{wind.wd10a},wd10m= #{wind.wd10m},wd10x= #{wind.wd10x},hw2a= #{wind.hw2a},cw2a= #{wind.cw2a},cw2a_kt_str= #{wind.cw2a_kt_str},cw2a_mps_str= #{wind.cw2a_mps_str} where imeiId=#{wind.imeiId}")
    void updateByImeiId(@Param("wind") Wind wind);

    @Update("update winds set time= #{wind.time},airportCode= #{wind.airportCode},airportName= #{wind.airportName},version= #{wind.version},sequenceNumber= #{wind.sequenceNumber},messageTime= #{wind.messageTime},messageType= #{wind.messageType},sensorId= #{wind.sensorId},locationId= #{wind.locationId},wsins= #{wind.wsins},wdins= #{wind.wdins},ws2a= #{wind.ws2a},ws2m= #{wind.ws2m},ws2x= #{wind.ws2x},wd2a= #{wind.wd2a},wd2m= #{wind.wd2m},wd2x= #{wind.wd2x},ws10a= #{wind.ws10a},ws10m= #{wind.ws10m},ws10x= #{wind.ws10x},wd10a= #{wind.wd10a},wd10m= #{wind.wd10m},wd10x= #{wind.wd10x},hw2a= #{wind.hw2a},cw2a= #{wind.cw2a},cw2a_kt_str= #{wind.cw2a_kt_str},cw2a_mps_str= #{wind.cw2a_mps_str} where imeiId=#{wind.imeiId} and sensorId=#{wind.sensorId}")
    void updateByImeiAndSensorId(@Param("wind") Wind wind);

    @Delete("delete from winds where airportCode=#{airportCode}")
    void deleteByAirportCode(@Param("airportCode") Integer airportCode);

    @Delete("delete from winds where airportName=#{airportName}")
    void deleteByAirportName(@Param("airportName") Integer airportName);

    @Delete("delete from winds where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Delete("delete from winds where imeiId=#{imeiId}")
    void deleteByImeiId(@Param("imeiId") Integer imeiId);

}
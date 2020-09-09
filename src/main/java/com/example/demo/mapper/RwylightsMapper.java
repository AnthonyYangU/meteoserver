package com.example.demo.mapper;

import com.example.demo.entity.Rwylights;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RwylightsMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into rwylightss(time,imeiId,airportCode,airportName,version,sequenceNumber,messageTime,messageType,sensorId,locationId,lights,ismanual,info,leftLightStatus,rightLightStatus) values(#{rwylights.time},#{rwylights.imeiId},#{rwylights.airportCode},#{rwylights.airportName},#{rwylights.version},#{rwylights.sequenceNumber},#{rwylights.messageTime},#{rwylights.messageType},#{rwylights.sensorId},#{rwylights.locationId},#{rwylights.lights},#{rwylights.ismanual},#{rwylights.info},#{rwylights.leftLightStatus},#{rwylights.rightLightStatus})")
    void insert(@Param("rwylights") Rwylights rwylights);

    @Select("select * from rwylightss where id=#{id}")
    Rwylights getById(@Param("id") Long id);

    @Select("select * from rwylightss where airportCode=#{airportCode}")
    List<Rwylights> getByAirportCode(@Param("airportCode") Integer airportCode);

    @Select("select * from rwylightss where airportName=#{airportName}")
    List<Rwylights> getByAirportName(@Param("airportName") String airportName);

    @Select("select * from rwylightss where imeiId=#{imeiId}")
    List<Rwylights> getByImeiId(@Param("imeiId") Integer imeiId);

    @Select("select * from rwylightss where imeiId=#{imeiId} and sensorId=#{sensorId}")
    Rwylights getByImeiAndSensorId(@Param("imeiId") Integer imeiId, @Param("sensorId") Integer sensorId);

    @Select("select * from rwylightss")
    List<Rwylights> getAll();

    @Update("update rwylightss set time= #{rwylights.time},imeiId= #{rwylights.imeiId},airportName= #{rwylights.airportName},version= #{rwylights.version},sequenceNumber= #{rwylights.sequenceNumber},messageTime= #{rwylights.messageTime},messageType= #{rwylights.messageType},sensorId= #{rwylights.sensorId},locationId= #{rwylights.locationId},lights= #{rwylights.lights},ismanual= #{rwylights.ismanual},info= #{rwylights.info},leftLightStatus= #{rwylights.leftLightStatus},rightLightStatus= #{rwylights.rightLightStatus} where airportCode=#{rwylights.airportCode}")
    void updateByAirportCode(@Param("rwylights") Rwylights rwylights);

    @Update("update rwylightss set time= #{rwylights.time},imeiId= #{rwylights.imeiId},airportCode= #{rwylights.airportCode},version= #{rwylights.version},sequenceNumber= #{rwylights.sequenceNumber},messageTime= #{rwylights.messageTime},messageType= #{rwylights.messageType},sensorId= #{rwylights.sensorId},locationId= #{rwylights.locationId},lights= #{rwylights.lights},ismanual= #{rwylights.ismanual},info= #{rwylights.info},leftLightStatus= #{rwylights.leftLightStatus},rightLightStatus= #{rwylights.rightLightStatus} where airportName=#{rwylights.airportName}")
    void updateByAirportName(@Param("rwylights") Rwylights rwylights);

    @Update("update rwylightss set time= #{rwylights.time},imeiId= #{rwylights.imeiId},airportCode= #{rwylights.airportCode},airportName= #{rwylights.airportName},version= #{rwylights.version},sequenceNumber= #{rwylights.sequenceNumber},messageTime= #{rwylights.messageTime},messageType= #{rwylights.messageType},sensorId= #{rwylights.sensorId},locationId= #{rwylights.locationId},lights= #{rwylights.lights},ismanual= #{rwylights.ismanual},info= #{rwylights.info},leftLightStatus= #{rwylights.leftLightStatus},rightLightStatus= #{rwylights.rightLightStatus} where id=#{rwylights.id}")
    void updateById(@Param("rwylights") Rwylights rwylights);

    @Update("update rwylightss set time= #{rwylights.time},airportCode= #{rwylights.airportCode},airportName= #{rwylights.airportName},version= #{rwylights.version},sequenceNumber= #{rwylights.sequenceNumber},messageTime= #{rwylights.messageTime},messageType= #{rwylights.messageType},sensorId= #{rwylights.sensorId},locationId= #{rwylights.locationId},lights= #{rwylights.lights},ismanual= #{rwylights.ismanual},info= #{rwylights.info},leftLightStatus= #{rwylights.leftLightStatus},rightLightStatus= #{rwylights.rightLightStatus} where imeiId=#{rwylights.imeiId}")
    void updateByImeiId(@Param("rwylights") Rwylights rwylights);

    @Update("update rwylightss set time= #{rwylights.time},airportCode= #{rwylights.airportCode},airportName= #{rwylights.airportName},version= #{rwylights.version},sequenceNumber= #{rwylights.sequenceNumber},messageTime= #{rwylights.messageTime},messageType= #{rwylights.messageType},sensorId= #{rwylights.sensorId},locationId= #{rwylights.locationId},lights= #{rwylights.lights},ismanual= #{rwylights.ismanual},info= #{rwylights.info},leftLightStatus= #{rwylights.leftLightStatus},rightLightStatus= #{rwylights.rightLightStatus} where imeiId=#{rwylights.imeiId} and sensorId=#{rwylights.sensorId}")
    void updateByImeiAndSensorId(@Param("rwylights") Rwylights rwylights);

    @Delete("delete from rwylightss where airportCode=#{airportCode}")
    void deleteByAirportCode(@Param("airportCode") Integer airportCode);

    @Delete("delete from rwylightss where airportName=#{airportName}")
    void deleteByAirportName(@Param("airportName") Integer airportName);

    @Delete("delete from rwylightss where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Delete("delete from rwylightss where imeiId=#{imeiId}")
    void deleteByImeiId(@Param("imeiId") Integer imeiId);

}
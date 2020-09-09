package com.example.demo.mapper;

import com.example.demo.entity.Vis;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VisMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into viss(time,imeiId,airportCode,airportName,version,sequenceNumber,messageTime,messageType,sensorId,locationId,rawrvr,rvr,rvr1a,rvr1a10m,rvr2a,rvr10a,rvr10m,rvr10x,rvr10t,rawmor,mor,mor1a,mor2a,mor10a,mor10x,visik,rawvis,vis,vis1a,vis2a,vis10a,vis10m,vis10x,bl,bl1a,bl2a,lights,edgelights,centerlights) values(#{vis.time},#{vis.imeiId},#{vis.airportCode},#{vis.airportName},#{vis.version},#{vis.sequenceNumber},#{vis.messageTime},#{vis.messageType},#{vis.sensorId},#{vis.locationId},#{vis.rawrvr},#{vis.rvr},#{vis.rvr1a},#{vis.rvr1a10m},#{vis.rvr2a},#{vis.rvr10a},#{vis.rvr10m},#{vis.rvr10x},#{vis.rvr10t},#{vis.rawmor},#{vis.mor},#{vis.mor1a},#{vis.mor2a},#{vis.mor10a},#{vis.mor10x},#{vis.visik},#{vis.rawvis},#{vis.vis},#{vis.vis1a},#{vis.vis2a},#{vis.vis10a},#{vis.vis10m},#{vis.vis10x},#{vis.bl},#{vis.bl1a},#{vis.bl2a},#{vis.lights},#{vis.edgelights},#{vis.centerlights})")
    void insert(@Param("vis") Vis vis);

    @Select("select * from viss where id=#{id}")
    Vis getById(@Param("id") Long id);

    @Select("select * from viss where airportCode=#{airportCode}")
    List<Vis> getByAirportCode(@Param("airportCode") Integer airportCode);

    @Select("select * from viss where airportName=#{airportName}")
    List<Vis> getByAirportName(@Param("airportName") String airportName);

    @Select("select * from viss where imeiId=#{imeiId}")
    List<Vis> getByImeiId(@Param("imeiId") Integer imeiId);

    @Select("select * from viss where imeiId=#{imeiId} and sensorId=#{sensorId}")
    Vis getByImeiAndSensorId(@Param("imeiId") Integer imeiId, @Param("sensorId") Integer sensorId);

    @Select("select * from viss")
    List<Vis> getAll();

    @Update("update viss set time= #{vis.time},imeiId= #{vis.imeiId},airportName= #{vis.airportName},version= #{vis.version},sequenceNumber= #{vis.sequenceNumber},messageTime= #{vis.messageTime},messageType= #{vis.messageType},sensorId= #{vis.sensorId},locationId= #{vis.locationId},rawrvr= #{vis.rawrvr},rvr= #{vis.rvr},rvr1a= #{vis.rvr1a},rvr1a10m= #{vis.rvr1a10m},rvr2a= #{vis.rvr2a},rvr10a= #{vis.rvr10a},rvr10m= #{vis.rvr10m},rvr10x= #{vis.rvr10x},rvr10t= #{vis.rvr10t},rawmor= #{vis.rawmor},mor= #{vis.mor},mor1a= #{vis.mor1a},mor2a= #{vis.mor2a},mor10a= #{vis.mor10a},mor10x= #{vis.mor10x},visik= #{vis.visik},rawvis= #{vis.rawvis},vis= #{vis.vis},vis1a= #{vis.vis1a},vis2a= #{vis.vis2a},vis10a= #{vis.vis10a},vis10m= #{vis.vis10m},vis10x= #{vis.vis10x},bl= #{vis.bl},bl1a= #{vis.bl1a},bl2a= #{vis.bl2a},lights= #{vis.lights},edgelights= #{vis.edgelights},centerlights= #{vis.centerlights} where airportCode=#{vis.airportCode}")
    void updateByAirportCode(@Param("vis") Vis vis);

    @Update("update viss set time= #{vis.time},imeiId= #{vis.imeiId},airportCode= #{vis.airportCode},version= #{vis.version},sequenceNumber= #{vis.sequenceNumber},messageTime= #{vis.messageTime},messageType= #{vis.messageType},sensorId= #{vis.sensorId},locationId= #{vis.locationId},rawrvr= #{vis.rawrvr},rvr= #{vis.rvr},rvr1a= #{vis.rvr1a},rvr1a10m= #{vis.rvr1a10m},rvr2a= #{vis.rvr2a},rvr10a= #{vis.rvr10a},rvr10m= #{vis.rvr10m},rvr10x= #{vis.rvr10x},rvr10t= #{vis.rvr10t},rawmor= #{vis.rawmor},mor= #{vis.mor},mor1a= #{vis.mor1a},mor2a= #{vis.mor2a},mor10a= #{vis.mor10a},mor10x= #{vis.mor10x},visik= #{vis.visik},rawvis= #{vis.rawvis},vis= #{vis.vis},vis1a= #{vis.vis1a},vis2a= #{vis.vis2a},vis10a= #{vis.vis10a},vis10m= #{vis.vis10m},vis10x= #{vis.vis10x},bl= #{vis.bl},bl1a= #{vis.bl1a},bl2a= #{vis.bl2a},lights= #{vis.lights},edgelights= #{vis.edgelights},centerlights= #{vis.centerlights} where airportName=#{vis.airportName}")
    void updateByAirportName(@Param("vis") Vis vis);

    @Update("update viss set time= #{vis.time},imeiId= #{vis.imeiId},airportCode= #{vis.airportCode},airportName= #{vis.airportName},version= #{vis.version},sequenceNumber= #{vis.sequenceNumber},messageTime= #{vis.messageTime},messageType= #{vis.messageType},sensorId= #{vis.sensorId},locationId= #{vis.locationId},rawrvr= #{vis.rawrvr},rvr= #{vis.rvr},rvr1a= #{vis.rvr1a},rvr1a10m= #{vis.rvr1a10m},rvr2a= #{vis.rvr2a},rvr10a= #{vis.rvr10a},rvr10m= #{vis.rvr10m},rvr10x= #{vis.rvr10x},rvr10t= #{vis.rvr10t},rawmor= #{vis.rawmor},mor= #{vis.mor},mor1a= #{vis.mor1a},mor2a= #{vis.mor2a},mor10a= #{vis.mor10a},mor10x= #{vis.mor10x},visik= #{vis.visik},rawvis= #{vis.rawvis},vis= #{vis.vis},vis1a= #{vis.vis1a},vis2a= #{vis.vis2a},vis10a= #{vis.vis10a},vis10m= #{vis.vis10m},vis10x= #{vis.vis10x},bl= #{vis.bl},bl1a= #{vis.bl1a},bl2a= #{vis.bl2a},lights= #{vis.lights},edgelights= #{vis.edgelights},centerlights= #{vis.centerlights} where id=#{vis.id}")
    void updateById(@Param("vis") Vis vis);

    @Update("update viss set time= #{vis.time},airportCode= #{vis.airportCode},airportName= #{vis.airportName},version= #{vis.version},sequenceNumber= #{vis.sequenceNumber},messageTime= #{vis.messageTime},messageType= #{vis.messageType},sensorId= #{vis.sensorId},locationId= #{vis.locationId},rawrvr= #{vis.rawrvr},rvr= #{vis.rvr},rvr1a= #{vis.rvr1a},rvr1a10m= #{vis.rvr1a10m},rvr2a= #{vis.rvr2a},rvr10a= #{vis.rvr10a},rvr10m= #{vis.rvr10m},rvr10x= #{vis.rvr10x},rvr10t= #{vis.rvr10t},rawmor= #{vis.rawmor},mor= #{vis.mor},mor1a= #{vis.mor1a},mor2a= #{vis.mor2a},mor10a= #{vis.mor10a},mor10x= #{vis.mor10x},visik= #{vis.visik},rawvis= #{vis.rawvis},vis= #{vis.vis},vis1a= #{vis.vis1a},vis2a= #{vis.vis2a},vis10a= #{vis.vis10a},vis10m= #{vis.vis10m},vis10x= #{vis.vis10x},bl= #{vis.bl},bl1a= #{vis.bl1a},bl2a= #{vis.bl2a},lights= #{vis.lights},edgelights= #{vis.edgelights},centerlights= #{vis.centerlights} where imeiId=#{vis.imeiId}")
    void updateByImeiId(@Param("vis") Vis vis);

    @Update("update viss set time= #{vis.time},airportCode= #{vis.airportCode},airportName= #{vis.airportName},version= #{vis.version},sequenceNumber= #{vis.sequenceNumber},messageTime= #{vis.messageTime},messageType= #{vis.messageType},sensorId= #{vis.sensorId},locationId= #{vis.locationId},rawrvr= #{vis.rawrvr},rvr= #{vis.rvr},rvr1a= #{vis.rvr1a},rvr1a10m= #{vis.rvr1a10m},rvr2a= #{vis.rvr2a},rvr10a= #{vis.rvr10a},rvr10m= #{vis.rvr10m},rvr10x= #{vis.rvr10x},rvr10t= #{vis.rvr10t},rawmor= #{vis.rawmor},mor= #{vis.mor},mor1a= #{vis.mor1a},mor2a= #{vis.mor2a},mor10a= #{vis.mor10a},mor10x= #{vis.mor10x},visik= #{vis.visik},rawvis= #{vis.rawvis},vis= #{vis.vis},vis1a= #{vis.vis1a},vis2a= #{vis.vis2a},vis10a= #{vis.vis10a},vis10m= #{vis.vis10m},vis10x= #{vis.vis10x},bl= #{vis.bl},bl1a= #{vis.bl1a},bl2a= #{vis.bl2a},lights= #{vis.lights},edgelights= #{vis.edgelights},centerlights= #{vis.centerlights} where imeiId=#{vis.imeiId} and sensorId=#{vis.sensorId}")
    void updateByImeiAndSensorId(@Param("vis") Vis vis);

    @Delete("delete from viss where airportCode=#{airportCode}")
    void deleteByAirportCode(@Param("airportCode") Integer airportCode);

    @Delete("delete from viss where airportName=#{airportName}")
    void deleteByAirportName(@Param("airportName") Integer airportName);

    @Delete("delete from viss where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Delete("delete from viss where imeiId=#{imeiId}")
    void deleteByImeiId(@Param("imeiId") Integer imeiId);

}
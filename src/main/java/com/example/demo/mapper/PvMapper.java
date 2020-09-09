package com.example.demo.mapper;

import com.example.demo.entity.Pv;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PvMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into pvs(time,imeiId,airportCode,airportName,version,sequenceNumber,messageTime,messageType,sensorId,locationId,rawvis,vis,vis1a,vis2a,vis10a,vis10m,vis10x,sensor_vis10m,sensor_vis10m_dir,sensor_vis10x,sensor_vis10x_dir) values(#{pv.time},#{pv.imeiId},#{pv.airportCode},#{pv.airportName},#{pv.version},#{pv.sequenceNumber},#{pv.messageTime},#{pv.messageType},#{pv.sensorId},#{pv.locationId},#{pv.rawvis},#{pv.vis},#{pv.vis1a},#{pv.vis2a},#{pv.vis10a},#{pv.vis10m},#{pv.vis10x},#{pv.sensor_vis10m},#{pv.sensor_vis10m_dir},#{pv.sensor_vis10x},#{pv.sensor_vis10x_dir})")
    void insert(@Param("pv") Pv pv);

    @Select("select * from pvs where id=#{id}")
    Pv getById(@Param("id") Long id);

    @Select("select * from pvs where airportCode=#{airportCode}")
    List<Pv> getByAirportCode(@Param("airportCode") Integer airportCode);

    @Select("select * from pvs where airportName=#{airportName}")
    List<Pv> getByAirportName(@Param("airportName") String airportName);

    @Select("select * from pvs where imeiId=#{imeiId}")
    List<Pv> getByImeiId(@Param("imeiId") Integer imeiId);

    @Select("select * from pvs where imeiId=#{imeiId} and sensorId=#{sensorId}")
    Pv getByImeiAndSensorId(@Param("imeiId") Integer imeiId, @Param("sensorId") Integer sensorId);

    @Select("select * from pvs")
    List<Pv> getAll();

    @Update("update pvs set time= #{pv.time},imeiId= #{pv.imeiId},airportName= #{pv.airportName},version= #{pv.version},sequenceNumber= #{pv.sequenceNumber},messageTime= #{pv.messageTime},messageType= #{pv.messageType},sensorId= #{pv.sensorId},locationId= #{pv.locationId},rawvis= #{pv.rawvis},vis= #{pv.vis},vis1a= #{pv.vis1a},vis2a= #{pv.vis2a},vis10a= #{pv.vis10a},vis10m= #{pv.vis10m},vis10x= #{pv.vis10x},sensor_vis10m= #{pv.sensor_vis10m},sensor_vis10m_dir= #{pv.sensor_vis10m_dir},sensor_vis10x= #{pv.sensor_vis10x},sensor_vis10x_dir= #{pv.sensor_vis10x_dir} where airportCode=#{pv.airportCode}")
    void updateByAirportCode(@Param("pv") Pv pv);

    @Update("update pvs set time= #{pv.time},imeiId= #{pv.imeiId},airportCode= #{pv.airportCode},version= #{pv.version},sequenceNumber= #{pv.sequenceNumber},messageTime= #{pv.messageTime},messageType= #{pv.messageType},sensorId= #{pv.sensorId},locationId= #{pv.locationId},rawvis= #{pv.rawvis},vis= #{pv.vis},vis1a= #{pv.vis1a},vis2a= #{pv.vis2a},vis10a= #{pv.vis10a},vis10m= #{pv.vis10m},vis10x= #{pv.vis10x},sensor_vis10m= #{pv.sensor_vis10m},sensor_vis10m_dir= #{pv.sensor_vis10m_dir},sensor_vis10x= #{pv.sensor_vis10x},sensor_vis10x_dir= #{pv.sensor_vis10x_dir} where airportName=#{pv.airportName}")
    void updateByAirportName(@Param("pv") Pv pv);

    @Update("update pvs set time= #{pv.time},imeiId= #{pv.imeiId},airportCode= #{pv.airportCode},airportName= #{pv.airportName},version= #{pv.version},sequenceNumber= #{pv.sequenceNumber},messageTime= #{pv.messageTime},messageType= #{pv.messageType},sensorId= #{pv.sensorId},locationId= #{pv.locationId},rawvis= #{pv.rawvis},vis= #{pv.vis},vis1a= #{pv.vis1a},vis2a= #{pv.vis2a},vis10a= #{pv.vis10a},vis10m= #{pv.vis10m},vis10x= #{pv.vis10x},sensor_vis10m= #{pv.sensor_vis10m},sensor_vis10m_dir= #{pv.sensor_vis10m_dir},sensor_vis10x= #{pv.sensor_vis10x},sensor_vis10x_dir= #{pv.sensor_vis10x_dir} where id=#{pv.id}")
    void updateById(@Param("pv") Pv pv);

    @Update("update pvs set time= #{pv.time},airportCode= #{pv.airportCode},airportName= #{pv.airportName},version= #{pv.version},sequenceNumber= #{pv.sequenceNumber},messageTime= #{pv.messageTime},messageType= #{pv.messageType},sensorId= #{pv.sensorId},locationId= #{pv.locationId},rawvis= #{pv.rawvis},vis= #{pv.vis},vis1a= #{pv.vis1a},vis2a= #{pv.vis2a},vis10a= #{pv.vis10a},vis10m= #{pv.vis10m},vis10x= #{pv.vis10x},sensor_vis10m= #{pv.sensor_vis10m},sensor_vis10m_dir= #{pv.sensor_vis10m_dir},sensor_vis10x= #{pv.sensor_vis10x},sensor_vis10x_dir= #{pv.sensor_vis10x_dir} where imeiId=#{pv.imeiId}")
    void updateByImeiId(@Param("pv") Pv pv);

    @Update("update pvs set time= #{pv.time},airportCode= #{pv.airportCode},airportName= #{pv.airportName},version= #{pv.version},sequenceNumber= #{pv.sequenceNumber},messageTime= #{pv.messageTime},messageType= #{pv.messageType},sensorId= #{pv.sensorId},locationId= #{pv.locationId},rawvis= #{pv.rawvis},vis= #{pv.vis},vis1a= #{pv.vis1a},vis2a= #{pv.vis2a},vis10a= #{pv.vis10a},vis10m= #{pv.vis10m},vis10x= #{pv.vis10x},sensor_vis10m= #{pv.sensor_vis10m},sensor_vis10m_dir= #{pv.sensor_vis10m_dir},sensor_vis10x= #{pv.sensor_vis10x},sensor_vis10x_dir= #{pv.sensor_vis10x_dir} where imeiId=#{pv.imeiId} and sensorId=#{pv.sensorId}")
    void updateByImeiAndSensorId(@Param("pv") Pv pv);

    @Delete("delete from pvs where airportCode=#{airportCode}")
    void deleteByAirportCode(@Param("airportCode") Integer airportCode);

    @Delete("delete from pvs where airportName=#{airportName}")
    void deleteByAirportName(@Param("airportName") Integer airportName);

    @Delete("delete from pvs where id=#{id}")
    void deleteById(@Param("id") Long id);

    @Delete("delete from pvs where imeiId=#{imeiId}")
    void deleteByImeiId(@Param("imeiId") Integer imeiId);

}
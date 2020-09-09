package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.ibatis.annotations.Update;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Meteo {
    private Long id;
    private Integer time;
    private Integer imeiId;
    private Integer airportCode;
    private String airportName;
    //头数据
    private Integer version;
    private Integer sequenceNumber;
    private Integer messageTime;
    private String messageType;
    private Integer sensorId;
    private String locationId;

    public Integer getImeiId() {
        return imeiId;
    }

    public void setImeiId(Integer imeiId) {
        this.imeiId = imeiId;
    }

    public Integer getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(Integer airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public Integer getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Integer messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }
    @JsonIgnore
    public String getCreateSql(){
        Class meteoClass = this.getClass();
        String totalClassName = meteoClass.getName();
        String className = totalClassName.substring(totalClassName.lastIndexOf(".")+1).toLowerCase();
        String s = "create table if not exists " + className + "s" +
                "(id bigint not null primary key AUTO_INCREMENT," +
                "airportCode int," +
                "airportName varchar(50),"+
                "imeiId int," +
                "time int," +
                "version int," +
                "sequenceNumber int," +
                "messageTime int," +
                "messageType varchar(20) not null," +
                "sensorId int," +
                "locationId varchar(20),";
        s = s + "constraint " + className + "_airportname " + "foreign key (airportName) references airports(airportName) on delete cascade on update cascade,";
        s = s + "constraint " + className + "_airportcode " + "foreign key (airportName) references airports(airportName) on delete cascade on update cascade,";
        String typeString = null;
        Field[] fields = meteoClass.getDeclaredFields();
        for(Field f : fields){
            f.setAccessible(true);
            var type = f.getType();
            if(type==Double.class){
                typeString = " double";
            }else if(type==Integer.class){
                typeString = " int";
            }else if(type==String.class){
                typeString = " varchar(20)";
            }
            s = s + f.getName() + typeString + ",";
        }

        s = s.substring(0,s.length()-1) + ")";
        return s;
    }

    @Override
    public String toString() {
        Class meteoClass = this.getClass();
        Field[] fields = meteoClass.getDeclaredFields();
        String s = "";
        String value = "";
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                Object test = f.get(this);
                if (test != null) {
                    s = s + f.getName() + ":" + String.valueOf(test) + ", ";
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return s;
    }
}

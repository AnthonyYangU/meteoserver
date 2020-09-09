package com.example.demo;

import com.example.demo.entity.Meteo;
import com.example.demo.entity.Press;
//import com.example.demo.mapper.MeteoMapper;
//import com.example.demo.mapper.PressMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private DataSource dataSource;

//    @Autowired
//    private MeteoMapper meteoMapper;

//    @Autowired
//    private PressMapper pressMapper;

    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        while(resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            System.out.println("id:" + id + " name:" + name + " address:" + address);
        }
    }
    @Test
    void testMeteoMapper(){
        Meteo meteo = new Meteo();

        meteo.setTime(1023456);
        meteo.setAirportCode(12456);
        meteo.setVersion(1);
        meteo.setSequenceNumber(12);
        meteo.setMessageTime(789);
        meteo.setMessageType("test");
        meteo.setSensorId(1);
        meteo.setLocationId("02L");
//        meteo.setAlt((double) 100);
//        meteoMapper.insert(meteo);
//        System.out.println(meteo);
//        meteoMapper.insert(meteo);
//          meteo = meteoMapper.getByairportCode(2456);
//        System.out.println(meteo);
////          meteoMapper.deleteByImeiId(1245656);
//          List<Meteo> meteos = meteoMapper.getAll();
//          for(Meteo meteo1 : meteos){
//              System.out.println(meteo1);
//          }
//        System.out.println(meteo);
//        System.out.println(meteo==null);
//        System.out.println(meteo!=null);
    }

    @Test
    void demo(){
//        Meteo meteo = new Meteo();
////        meteo.setId((long)7);
//        meteo.setTime(102345786);
//        meteo.setImeiId((long) 12456);
//        meteo.setVersion(3);
//        meteo.setSequenceNumber(12);
//        meteo.setMessageTime(789);
//        meteo.setMessageType("test");
//        meteo.setSensorId(1);
//        meteo.setLocationId("02L");
//        meteo.setAlt((double) 100);
//        meteoMapper.insert(meteo);
//        meteoMapper.updateByImeiId(meteo);
//        meteo = meteoMapper.getByID((long) 1);
//        System.out.println(meteo);
    }
}

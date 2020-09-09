package com.example.demo;

import com.example.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class DatabaseInitializer {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    public void init() throws SQLException{
        try(var conn = dataSource.getConnection()){
            try (var stmt = conn.createStatement()) {
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (" //
                        + "id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, " //
                        + "name VARCHAR(50) NOT NULL, " //
                        + "address varchar(100) default null)"
                );
            }

            try(var stmt = conn.createStatement()){
                stmt.executeUpdate("create table if not exists airports(" +
                        "id bigint primary key AUTO_INCREMENT," +
                        "airportCode int not null unique," +
                        "airportName varchar(50) unique," +
                        "latitude DOUBLE," +
                        "longitude DOUBLE)");
            }

            try(var stmt = conn.createStatement()){
                stmt.executeUpdate("create table if not exists meteos(" +
                        "id bigint not null primary key AUTO_INCREMENT," +
                        "airportCode int," +
                        "airportName varchar(50),"+
                        "imeiId int, " +
                        "time int," +
                        "version int," +
                        "sequenceNumber int," +
                        "messageTime int," +
                        "messageType varchar(20) not null," +
                        "sensorId int," +
                        "locationId varchar(20)," +
                        "constraint meteo_airportname foreign key (airportName) references airports(airportName) on delete cascade on update cascade," +
                        "constraint meteo_airportcode foreign key (airportCode) references airports(airportCode) on delete cascade on update cascade )");
            }

            try(var stmt = conn.createStatement()){
                stmt.executeUpdate(new Humitemp().getCreateSql());
            }

            try(var stmt = conn.createStatement()){
                stmt.executeUpdate(new Press().getCreateSql());
            }
            try(var stmt = conn.createStatement()){
                stmt.executeUpdate(new Pv().getCreateSql());
            }
            try(var stmt = conn.createStatement()){
                stmt.executeUpdate(new Pw().getCreateSql());
            }
            try(var stmt = conn.createStatement()){
                stmt.executeUpdate(new Rain().getCreateSql());
            }
            try(var stmt = conn.createStatement()){
                stmt.executeUpdate(new Rosa().getCreateSql());
            }
            try(var stmt = conn.createStatement()){
                stmt.executeUpdate(new Rwylights().getCreateSql());
            }
            try(var stmt = conn.createStatement()){
                stmt.executeUpdate(new Vis().getCreateSql());
            }
            try(var stmt = conn.createStatement()){
                stmt.executeUpdate(new Wind().getCreateSql());
            }

        }
    }
}

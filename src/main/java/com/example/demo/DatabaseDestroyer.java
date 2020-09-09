package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;

//@Component
public class DatabaseDestroyer {
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void dropAllTables(){
        try(var conn = dataSource.getConnection()) {
            try (var stmt = conn.createStatement()) {
                stmt.addBatch("DROP table  if exists clouds");
                stmt.addBatch("DROP table  if exists humitemps");
                stmt.addBatch("DROP table  if exists meteos");
                stmt.addBatch("DROP table  if exists presss");
                stmt.addBatch("DROP table  if exists pvs");
                stmt.addBatch("DROP table  if exists pws");
                stmt.addBatch("DROP table  if exists rains");
                stmt.addBatch("DROP table  if exists rosas");
                stmt.addBatch("DROP table  if exists rwylightss");
                stmt.addBatch("DROP table  if exists viss");
                stmt.addBatch("DROP table  if exists winds");
                stmt.addBatch("DROP table  if exists airports");
                stmt.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

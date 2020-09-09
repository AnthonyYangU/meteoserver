package com.example.demo.mapper;

import com.example.demo.entity.User;
import jdk.jfr.Registered;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id}")
    User getById(@Param("id") long id);

    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into users (name,address) values(#{user.name},#{user.address})")
    void insert(@Param("user") User user);
}

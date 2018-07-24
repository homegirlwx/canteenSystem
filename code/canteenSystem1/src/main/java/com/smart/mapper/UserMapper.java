package com.smart.mapper;

import com.smart.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE userId = #{userId}")
    User findByName(@Param("userId") String userId);

    @Insert("INSERT INTO users(userId, userName, password) VALUES(#{userId} ,#{userName}, #{password})")
    void insert( User user);

    @Update({"UPDATE users SET userId = #{userAlias}, userName = #{userName}, password = #{password}"})
    void update(@Param("userId") String userAlias, @Param("userName") String userName, @Param("passwaord") String password);

    @Delete("DELETE FROM users WHERE userName = #{userId}")
    void delete(@Param("userId") String userAlias);
}

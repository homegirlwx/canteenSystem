package com.smart.mapper;

import com.smart.domain.ShopCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShopCartMapper {

    @Select("SELECT foodId FROM shopcart WHERE userId = #{userId}")
    List<String> showAll(@Param("foodId") int foodId);

    @Update("UPDATE shopcart SET num = #{num} WHERE foodId = #{foodId} AND userId = #{userId}")
    void updateNum(@Param("num") int num,, @Param("foodId") int foodId, @Param("userId") int userId);


}

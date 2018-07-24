package com.smart.mapper;

import com.smart.domain.Food;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FoodMapper {
    @Select("SELECT * FROM foods WHERE foodName = #{foodName}")
    Food findByFoodName(@Param("foodName") String foodName);

    @Insert("INSERT INTO foods(foodName, foodPrice) VALUES(#{foodName}, #{foodPrice})")
    void add(Food food);

    @Update("UPDATE foods SET foodPrice = #{foodPrice} WHERE foodName = #{foodName}")
    void update(@Param("foodName") String foodName, @Param("foodPrice") double foodPrice);

    @Delete("DELETE FROM foods WHERE foodName = #{foodName}")
    void delete(@Param("foodName") String foodName);
}

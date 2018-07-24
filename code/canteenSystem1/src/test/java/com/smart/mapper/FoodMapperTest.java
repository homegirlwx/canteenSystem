package com.smart.mapper;

import com.smart.domain.Food;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodMapperTest {

    @Autowired
    private FoodMapper foodMapper;

    @Test
    public void testInsert(){
        Food food = new Food();
        food.setFoodPrice(0.6);
        food.setFoodName("what");
        foodMapper.add(food);


    }
    @Test
    public void findByFoodNameTest(){
        Food food = foodMapper.findByFoodName("Rice");
        assertThat(food.getFoodName(),equalTo("Rice"));
        assertThat(food.getFoodPrice(), equalTo(0.5));
        //assertThat(food.getFoodName()).isEqualTo("Rice");
        //assertThat(food.getFoodPrice()).isEqualTo(0.5);
        System.out.println(food.toString());
    }

    @Test
    public void updateFoodTest(){
        foodMapper.update("Rice", 1.6);
    }

    @Test
    public void deleteTest(){
        foodMapper.delete("Rice");
    }
}

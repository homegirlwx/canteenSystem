package com.smart.mapper;

import com.smart.domain.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void testadd(){
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setUserId(123);
        order.setPayment(100.2);
        order.setPaymentStatus(2);
        order.setPaymentTime(new Date());
        orderMapper.addOrder(order);
        System.out.println(order.getOrderId());

    }
    @Test
    public void findByOrderIdTest(){

        Order order = orderMapper.findByOrderId("1");
        assertThat(order.getPayment(),equalTo(100.2));
        assertThat(order.getPaymentStatus(), equalTo(2));
        //assertThat(food.getFoodName()).isEqualTo("Rice");
        //assertThat(food.getFoodPrice()).isEqualTo(0.5);
        System.out.println(order.getOrderId());
    }

    @Test
    public void updateFoodTest(){

        orderMapper.updatePayment(1, 150);
    }

    @Test
    public void deleteTest(){
    orderMapper.deleteByOrderId(1);
    }
}

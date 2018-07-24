package com.smart.mapper;


import com.smart.domain.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
        @Select("SELECT * FROM orders WHERE orderId = #{orderId}")
        Order findByOrderId(@Param("orderId") String orderId);

        @Select("SELECT * FROM orders WHERE userId = #{userId}")
        List<Order> findByUserId(@Param("userId") int userId);

        @Insert("INSERT INTO orders (payment, paymentType, paymentStatus, createTime, userId) VALUES(#{payment}, #{paymentType},  #{paymentStatus},  #{createTime},  #{userId})")
        @Options(useGeneratedKeys = true, keyProperty = "orderId", keyColumn = "orderId")
        void addOrder(Order order);

        @Update("UPDATE orders SET paymentType = #{paymentType} WHERE orderId = #{orderId}")
        void updatePaymentType(@Param("orderId") int orderId, @Param("paymentType") int paymentType);

        @Update("UPDATE orders SET paymentStatus = #{paymentStatus} WHERE orderId = #{orderId}")
        void updatePaymentStatus(@Param("orderId") int orderId, @Param("paymentStatus") int paymentStatus);

        @Update("UPDATE orders SET payment = #{payment} WHERE orderId = #{orderId}")
        void updatePayment(@Param("orderId") int orderId, @Param("payment") double payment);

        @Delete("DELETE FROM orders WHERE orderId= #{orderId}")
        void deleteByOrderId(@Param("orderId") int orderId);

}

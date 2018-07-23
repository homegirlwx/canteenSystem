package com.smart.dao;

import com.smart.domain.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class FoodDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String MATCH_COUNT_SQL = " SELECT count(*) FROM t_food  " +
            " WHERE food_name =? and food_price=? ";
    private final static String UPDATE_LOGIN_INFO_SQL = " UPDATE t_food SET " +
            " food_name=?,food_price=?  WHERE food_name =?";

    public int getMatchCount(String foodName, String foodPrice) {

        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL, new Object[]{foodName, foodPrice}, Integer.class);
    }

    public Food findFoodByFoodName(final String foodName) {
        String sqlStr = " SELECT food_name,food_price "
                + " FROM t_food WHERE food_name =? ";
        final Food food = new Food();
        jdbcTemplate.query(sqlStr, new Object[]{foodName},
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        food.setFoodName(foodName);
                        food.setFoodPrice(rs.getDouble("food_price"));
                        //user.setCredits(rs.getInt("credits"));
                    }
                });
        return food;
    }

}

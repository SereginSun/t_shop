package com.seregin.tshop.dao;

import com.seregin.tshop.models.Item;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements RowMapper<Item> {
    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setName(rs.getString("name"));
        item.setPrice(rs.getDouble("price"));
        item.setCategory(rs.getString("category"));
        item.setDescription(rs.getString("description"));
        item.setAmount(rs.getInt("amount"));
        return item;
    }
}

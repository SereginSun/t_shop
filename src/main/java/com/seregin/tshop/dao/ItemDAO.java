package com.seregin.tshop.dao;

import com.seregin.tshop.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Item> index() {
        return jdbcTemplate.query("SELECT * FROM item", new ItemMapper());
    }

    public Item show(int id) {
        return jdbcTemplate.query(
                "SELECT * FROM item WHERE id=?", new Object[]{id}, new ItemMapper()
        ).stream().findAny().orElse(null);
    }
}

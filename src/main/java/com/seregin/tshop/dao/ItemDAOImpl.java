package com.seregin.tshop.dao;

import com.seregin.tshop.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Seregin Vladimir
 */
@Repository
public class ItemDAOImpl implements ItemDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
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

    @Override
    public void add(Item item) {
        jdbcTemplate.update(
                "INSERT INTO item(name, price, category, description, amount) VALUES(?, ?, ?, ?, ?)",
                item.getName(), item.getPrice(), item.getCategory(), item.getDescription(), item.getAmount()
        );
    }

    @Override
    public void edit(int id, Item updatedItem) {
        jdbcTemplate.update(
                "UPDATE item SET name=?, price=?, category=?, description=?, amount=? WHERE id=?",
                updatedItem.getName(),
                updatedItem.getPrice(),
                updatedItem.getCategory(),
                updatedItem.getDescription(),
                updatedItem.getAmount(),
                id
        );
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM item WHERE id=?", id);
    }
}

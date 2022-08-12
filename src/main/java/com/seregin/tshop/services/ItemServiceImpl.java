package com.seregin.tshop.services;

import com.seregin.tshop.dao.ItemDAO;
import com.seregin.tshop.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Seregin Vladimir
 */
@Service
public class ItemServiceImpl implements ItemService {
    private ItemDAO itemDAO;

    @Autowired
    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @Override
    public List<Item> index() {
        return itemDAO.index();
    }

    @Override
    public Item show(int id) {
        return itemDAO.show(id);
    }

    @Override
    public void add(Item item) {
        itemDAO.add(item);
    }

    @Override
    public void edit(int id, Item updatedItem) {
        itemDAO.edit(id, updatedItem);
    }

    @Override
    public void delete(int id) {
        itemDAO.delete(id);
    }
}

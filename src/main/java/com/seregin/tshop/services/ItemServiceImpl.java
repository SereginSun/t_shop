package com.seregin.tshop.services;

import com.seregin.tshop.dao.ItemDAO;
import com.seregin.tshop.models.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Seregin Vladimir
 */
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemDAO itemDAO;

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

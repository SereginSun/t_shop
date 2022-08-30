package com.seregin.tshop.services;

import com.seregin.tshop.models.Item;

import java.util.List;

/**
 * @author Seregin Vladimir
 */
public interface ItemService {
    List<Item> index(int id);

    Item show(int id);

    void add(Item item);

    void edit(int id, Item updatedItem);

    void delete(int id);
}

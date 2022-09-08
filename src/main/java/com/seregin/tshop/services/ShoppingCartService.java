package com.seregin.tshop.services;

import com.seregin.tshop.models.Item;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {

    void addItem(Item item);

    Map<Item, Integer> getItemsInCart();

    BigDecimal getTotal();

    void removeItem(Item item);
}

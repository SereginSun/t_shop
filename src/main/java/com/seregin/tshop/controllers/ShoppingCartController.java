package com.seregin.tshop.controllers;

import com.seregin.tshop.models.Item;
import com.seregin.tshop.services.ItemService;
import com.seregin.tshop.services.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shoppingCart")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    private final ItemService itemService;

    @GetMapping()
    public String shoppingCart(Model model) {
        model.addAttribute("items", shoppingCartService.getItemsInCart());
        model.addAttribute("total", shoppingCartService.getTotal());
        return "cart/myCart";
    }

    @GetMapping("/addItem/{itemId}")
    public String addItemToShoppingCart(@PathVariable("itemId") int id, Model model) {
        Item item = itemService.show(id);
        shoppingCartService.addItem(item);
        shoppingCart(model);
        return "cart/myCart";
    }

    @GetMapping("/removeItem/{itemId}")
    public String removeItemFromCart(@PathVariable("itemId") int id, Model model) {
        Item item = itemService.show(id);
        shoppingCartService.removeItem(item);
        shoppingCart(model);
        return "cart/myCart";
    }
}

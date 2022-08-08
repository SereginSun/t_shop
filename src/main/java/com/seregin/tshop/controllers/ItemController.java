package com.seregin.tshop.controllers;

import com.seregin.tshop.dao.ItemDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {
    private final ItemDAO itemDAO;

    public ItemController(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("item", itemDAO.index());
        return "item/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", itemDAO.show(id));
        return "item/show";
    }
}

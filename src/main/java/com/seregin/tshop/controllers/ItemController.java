package com.seregin.tshop.controllers;

import com.seregin.tshop.models.Item;
import com.seregin.tshop.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Seregin Vladimir
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("item", itemService.index());
        return "item/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", itemService.show(id));
        return "item/show";
    }

    @GetMapping("/new")
    public String newItem(@ModelAttribute("item") Item item) {
        return "item/newItem";
    }

    @PostMapping()
    public String create(@ModelAttribute("item") Item item) {
        itemService.add(item);
        return "redirect:/item";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("item", itemService.show(id));
        return "item/edit";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("item") Item item,
                         @PathVariable("id") int id) {
        itemService.edit(id, item);
        return "redirect:/item";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        itemService.delete(id);
        return "redirect:/item";
    }
}

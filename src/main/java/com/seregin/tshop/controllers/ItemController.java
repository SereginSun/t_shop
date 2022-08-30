package com.seregin.tshop.controllers;

import com.seregin.tshop.models.Category;
import com.seregin.tshop.models.Item;
import com.seregin.tshop.services.CategoryServiceImpl;
import com.seregin.tshop.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Seregin Vladimir
 */
@Controller
@RequestMapping("/tshop")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final CategoryServiceImpl categoryService;

    @GetMapping()
    public String indexCategory(Model model) {
        model.addAttribute("category", categoryService.index());
        return "category/index";
    }

    @GetMapping("/{category_id}")
    public String index(@PathVariable("category_id") int id, Model model) {
        model.addAttribute("items", itemService.index(id));
        return "item/index";
    }

    @GetMapping("/item/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", itemService.show(id));
        return "item/show";
    }

    @GetMapping("/item/new")
    public String newItem(@ModelAttribute("item") Item item, Model model) {
        model.addAttribute("category", categoryService.index());
        return "item/newItem";
    }

    @PostMapping("/item")
    public String create(@ModelAttribute("item") Item item) {
        itemService.add(item);
        return "redirect:/tshop";
    }

    @GetMapping("/item/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("item", itemService.show(id));
        model.addAttribute("category", categoryService.index());
        return "item/edit";
    }

    @PostMapping("/item/{id}")
    public String update(@ModelAttribute("item") Item item,
                         @PathVariable("id") int id) {
        itemService.edit(id, item);
        return "redirect:/tshop";
    }

    @DeleteMapping("/item/{id}")
    public String delete(@PathVariable("id") int id) {
        itemService.delete(id);
        return "redirect:/tshop";
    }
}

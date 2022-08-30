package com.seregin.tshop.services;

import com.seregin.tshop.dao.CategoryDAO;
import com.seregin.tshop.models.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Seregin Vladimir
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDAO categoryDAO;

    @Override
    public List<Category> index() {
        return categoryDAO.index();
    }
}

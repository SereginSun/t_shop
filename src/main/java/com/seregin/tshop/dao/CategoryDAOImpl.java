package com.seregin.tshop.dao;

import com.seregin.tshop.models.Category;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryDAOImpl implements CategoryDAO {
    private final SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Category> index() {
        Session session =  sessionFactory.getCurrentSession();
        return session.createQuery("select c from Category c", Category.class).getResultList();
    }
}

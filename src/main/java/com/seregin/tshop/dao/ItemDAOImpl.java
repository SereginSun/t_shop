package com.seregin.tshop.dao;

import com.seregin.tshop.models.Item;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Seregin Vladimir
 */
@Repository
@RequiredArgsConstructor
public class ItemDAOImpl implements ItemDAO {
    private final SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Item> index() {
        Session session =  sessionFactory.getCurrentSession();
        return session.createQuery("select i from Item i", Item.class).getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Item show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Item.class, id);
    }

    @Override
    @Transactional
    public void add(Item item) {
        Session session = sessionFactory.getCurrentSession();
        session.save(item);
    }

    @Override
    @Transactional
    public void edit(int id, Item updatedItem) {
        Session session = sessionFactory.getCurrentSession();
        Item itemToBeEdited = session.get(Item.class, id);
        itemToBeEdited.setName(updatedItem.getName());
        itemToBeEdited.setPrice(updatedItem.getPrice());
        itemToBeEdited.setCategory(updatedItem.getCategory());
        itemToBeEdited.setDescription(updatedItem.getDescription());
        itemToBeEdited.setAmount(updatedItem.getAmount());
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Item.class, id));
    }
}

package com.codegym.receipt.repository.receipt;

import com.codegym.receipt.model.Receipt;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class ReceiptRepository implements IReceiptRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Receipt> findAll() {
        TypedQuery<Receipt> query = em.createQuery("select s from Receipt s", Receipt.class);
        return query.getResultList();
    }

    @Override
    public Receipt findById(Long id) {
        TypedQuery<Receipt> query = em.createQuery("select c from Receipt c where c.id=:id", Receipt.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        }catch ( NoResultException e){
            return null;
        }
    }

    @Override
    public void save(Receipt receipt) {
        if (receipt.getId() != null) {
            em.merge(receipt);
        } else {
            em.persist(receipt);
        }
    }

    @Override
    public void remove(Long id) {
        Receipt receipt = findById(id);
        if (receipt != null) {
            em.remove(receipt);
        }
    }
}
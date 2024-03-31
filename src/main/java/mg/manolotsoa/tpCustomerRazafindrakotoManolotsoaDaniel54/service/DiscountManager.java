/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.manolotsoa.tpCustomerRazafindrakotoManolotsoaDaniel54.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.manolotsoa.tpCustomerRazafindrakotoManolotsoaDaniel54.entity.Discount;

/**
 *
 * @author manou
 */
public class DiscountManager {
    @PersistenceContext(unitName = "discountPU")
    private EntityManager em;

    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    @Transactional
    public Discount update(Discount discount) {
        return em.merge(discount);
    }

    @Transactional
    public void persist(Discount discount) {
        em.persist(discount);
    }

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }
}

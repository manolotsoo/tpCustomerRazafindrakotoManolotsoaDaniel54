/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.manolotsoa.tpCustomerRazafindrakotoManolotsoaDaniel54.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.manolotsoa.tpCustomerRazafindrakotoManolotsoaDaniel54.entity.Discount;

/**
 * Gère la persistance des Discounts.
 *
 * @author manou
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    public List<Discount> getAllDiscountsOrderByAsc() {
        Query query = em.createNamedQuery("Discount.findAllRateAsc");
        return query.getResultList();
    }

    public List<Discount> getAllDiscountsOrderByDesc() {
        Query query = em.createNamedQuery("Discount.findAllRateDesc");
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

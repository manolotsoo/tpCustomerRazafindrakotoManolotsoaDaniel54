/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.manolotsoa.tpCustomerRazafindrakotoManolotsoaDaniel54.jsf;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import mg.manolotsoa.tpCustomerRazafindrakotoManolotsoaDaniel54.entity.Customer;
import mg.manolotsoa.tpCustomerRazafindrakotoManolotsoaDaniel54.entity.Discount;
import mg.manolotsoa.tpCustomerRazafindrakotoManolotsoaDaniel54.service.CustomerManager;
import mg.manolotsoa.tpCustomerRazafindrakotoManolotsoaDaniel54.service.DiscountManager;

/**
 *
 * @author manou
 */
@Named
@ViewScoped
public class CustomerDetailsBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    @Inject
    private CustomerManager customerManager;

    @Inject
    private DiscountManager discountManager;

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    /**
     * Retourne les détails du client courant (contenu dans l'attribut customer
     * de cette classe).
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Action handler - met à jour dans la base de données les données du client
     * contenu dans la variable d'instance customer.
     *
     * @return la prochaine page à afficher, celle qui affiche la liste des
     * clients.
     */
    public String update() {
        // Modifie la base de données.
        // Il faut affecter à customer (sera expliqué dans le cours).
        customer = customerManager.update(customer);
        return "customerList";
    }

    public void loadCustomer() {
        this.customer = this.customerManager.findById(idCustomer);
    }

    /**
     * Retourne la liste de tous les Discount.
     */
    public List<Discount> getDiscounts() {
//        Filter by java
//        List<Discount> allDiscounts = discountManager.getAllDiscounts();
//        Collections.sort(allDiscounts, Comparator.comparing(Discount::getRate));
        return discountManager.getAllDiscountsOrderByDesc();
    }
}

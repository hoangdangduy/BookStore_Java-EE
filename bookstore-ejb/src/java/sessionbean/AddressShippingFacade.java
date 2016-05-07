/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.AddressShipping;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hoangdd
 */
@Stateless
public class AddressShippingFacade extends AbstractFacade<AddressShipping> implements AddressShippingFacadeLocal {

    @PersistenceContext(unitName = "bookstore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressShippingFacade() {
        super(AddressShipping.class);
    }
    
    @Override
    public int getMaxID() {
        int idMax = (int) em.createQuery(
                "SELECT MAX(a.idAddressShipping) FROM AddressShipping a")
                .getSingleResult();
        return idMax;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.CartSave;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hoangdd
 */
@Stateless
public class CartSaveFacade extends AbstractFacade<CartSave> implements CartSaveFacadeLocal {

    @PersistenceContext(unitName = "bookstore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CartSaveFacade() {
        super(CartSave.class);
    }

    @Override
    public int getMaxID() {
        int idMax = (int) em.createQuery(
                "SELECT MAX(c.idCartSave) FROM CartSave c")
                .getSingleResult();
        return idMax;
//        return 10;
    }
}

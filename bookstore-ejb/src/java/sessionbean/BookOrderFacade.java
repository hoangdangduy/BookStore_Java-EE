/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.BookOrder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hoangdd
 */
@Stateless
public class BookOrderFacade extends AbstractFacade<BookOrder> implements BookOrderFacadeLocal {

    @PersistenceContext(unitName = "bookstore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookOrderFacade() {
        super(BookOrder.class);
    }
    
    @Override
    public int getMaxID() {
        int idMax = (int) em.createQuery(
                "SELECT MAX(b.idBookOrder) FROM BookOrder b")
                .getSingleResult();
        return idMax;
//        return 10;
    }
    
}

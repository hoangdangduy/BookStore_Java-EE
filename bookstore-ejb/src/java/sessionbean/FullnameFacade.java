/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.Fullname;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hoangdd
 */
@Stateless
public class FullnameFacade extends AbstractFacade<Fullname> implements FullnameFacadeLocal {

    @PersistenceContext(unitName = "bookstore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FullnameFacade() {
        super(Fullname.class);
    }
    
    @Override
    public int getMaxID() {
        int idMax = (int) em.createQuery(
                "SELECT MAX(f.idFullname) FROM Fullname f")
                .getSingleResult();
        return idMax;
    }
}

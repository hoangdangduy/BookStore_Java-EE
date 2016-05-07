/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.CustomerMember;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hoangdd
 */
@Stateless
public class CustomerMemberFacade extends AbstractFacade<CustomerMember> implements CustomerMemberFacadeLocal {

    @PersistenceContext(unitName = "bookstore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerMemberFacade() {
        super(CustomerMember.class);
    }

    
    @Override
    public CustomerMember getCustomerMember(String username, String password) {
        CustomerMember customerMember;
        try {
            customerMember = (CustomerMember) em.createQuery(
                    "SELECT c FROM CustomerMember c WHERE c.username = :username AND c.password = :password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
            return customerMember;
        } catch (NoResultException | NonUniqueResultException | NullPointerException e) {
            return null;
        }
    }

    // ham nay khong dung, nhung van de lai, sau nay co the dung
    @Override
    public CustomerMember exitAccount(Object username, Object password) {
        javax.persistence.Query qr = getEntityManager().createNamedQuery(CustomerMember.class.getSimpleName() + ".exitAccount");
        qr.setParameter("username", username);
        qr.setParameter("password", password);
        CustomerMember customerMember;
        try {
            customerMember = (CustomerMember) qr.getSingleResult();
            return customerMember;
        } catch (NoResultException | NonUniqueResultException | NullPointerException nre) {
            return null;
        }
    }

    
    
    
}

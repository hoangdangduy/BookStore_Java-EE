/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hoangdd
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> implements BookFacadeLocal {

    @PersistenceContext(unitName = "bookstore-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }

    @Override
    public List<Book> searchBookByName(String name) {
        try {
            List<Book> listBook = em.createQuery(
                    "SELECT b FROM Book b WHERE b.title LIKE :title")
                    .setParameter("title", "%" + name + "%")
                    .getResultList();
            return listBook;
        } catch (Exception e) {
            return null;
        }
    }

}

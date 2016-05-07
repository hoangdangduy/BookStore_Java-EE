/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.BookOrder;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface BookOrderFacadeLocal {

    void create(BookOrder bookOrder);

    void edit(BookOrder bookOrder);

    void remove(BookOrder bookOrder);

    BookOrder find(Object id);

    List<BookOrder> findAll();

    List<BookOrder> findRange(int[] range);

    int count();

    int getMaxID();
}

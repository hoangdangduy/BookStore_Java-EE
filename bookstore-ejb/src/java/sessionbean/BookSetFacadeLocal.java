/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.BookSet;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface BookSetFacadeLocal {

    void create(BookSet bookSet);

    void edit(BookSet bookSet);

    void remove(BookSet bookSet);

    BookSet find(Object id);

    List<BookSet> findAll();

    List<BookSet> findRange(int[] range);

    int count();
    
}

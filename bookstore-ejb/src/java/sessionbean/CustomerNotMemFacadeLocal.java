/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.CustomerNotMem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface CustomerNotMemFacadeLocal {

    void create(CustomerNotMem customerNotMem);

    void edit(CustomerNotMem customerNotMem);

    void remove(CustomerNotMem customerNotMem);

    CustomerNotMem find(Object id);

    List<CustomerNotMem> findAll();

    List<CustomerNotMem> findRange(int[] range);

    int count();
    
}

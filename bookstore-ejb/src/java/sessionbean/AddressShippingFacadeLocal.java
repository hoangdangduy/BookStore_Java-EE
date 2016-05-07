/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.AddressShipping;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface AddressShippingFacadeLocal {

    void create(AddressShipping addressShipping);

    void edit(AddressShipping addressShipping);

    void remove(AddressShipping addressShipping);

    AddressShipping find(Object id);

    List<AddressShipping> findAll();

    List<AddressShipping> findRange(int[] range);

    int count();
    
    int getMaxID();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.StaffStore;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface StaffStoreFacadeLocal {

    void create(StaffStore staffStore);

    void edit(StaffStore staffStore);

    void remove(StaffStore staffStore);

    StaffStore find(Object id);

    List<StaffStore> findAll();

    List<StaffStore> findRange(int[] range);

    int count();
    
}

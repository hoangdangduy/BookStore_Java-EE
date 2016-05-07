/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.StaffManager;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface StaffManagerFacadeLocal {

    void create(StaffManager staffManager);

    void edit(StaffManager staffManager);

    void remove(StaffManager staffManager);

    StaffManager find(Object id);

    List<StaffManager> findAll();

    List<StaffManager> findRange(int[] range);

    int count();
    
}

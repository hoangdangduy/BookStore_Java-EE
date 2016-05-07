/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.StaffShipper;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface StaffShipperFacadeLocal {

    void create(StaffShipper staffShipper);

    void edit(StaffShipper staffShipper);

    void remove(StaffShipper staffShipper);

    StaffShipper find(Object id);

    List<StaffShipper> findAll();

    List<StaffShipper> findRange(int[] range);

    int count();
    
}

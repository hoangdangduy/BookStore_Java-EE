/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.ShippingInfor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface ShippingInforFacadeLocal {

    void create(ShippingInfor shippingInfor);

    void edit(ShippingInfor shippingInfor);

    void remove(ShippingInfor shippingInfor);

    ShippingInfor find(Object id);

    List<ShippingInfor> findAll();

    List<ShippingInfor> findRange(int[] range);

    int count();
    
}

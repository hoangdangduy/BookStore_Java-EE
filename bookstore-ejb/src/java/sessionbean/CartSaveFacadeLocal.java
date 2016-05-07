/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.CartSave;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface CartSaveFacadeLocal {

    void create(CartSave cartSave);

    void edit(CartSave cartSave);

    void remove(CartSave cartSave);

    CartSave find(Object id);

    List<CartSave> findAll();

    List<CartSave> findRange(int[] range);

    int count();

    int getMaxID();
}

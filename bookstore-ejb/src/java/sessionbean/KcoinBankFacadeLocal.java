/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.KcoinBank;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface KcoinBankFacadeLocal {

    void create(KcoinBank kcoinBank);

    void edit(KcoinBank kcoinBank);

    void remove(KcoinBank kcoinBank);

    KcoinBank find(Object id);

    List<KcoinBank> findAll();

    List<KcoinBank> findRange(int[] range);

    int count();
    
}

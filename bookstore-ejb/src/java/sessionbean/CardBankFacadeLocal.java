/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.CardBank;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface CardBankFacadeLocal {

    void create(CardBank cardBank);

    void edit(CardBank cardBank);

    void remove(CardBank cardBank);

    CardBank find(Object id);

    List<CardBank> findAll();

    List<CardBank> findRange(int[] range);

    int count();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.StateReadEvent;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface StateReadEventFacadeLocal {

    void create(StateReadEvent stateReadEvent);

    void edit(StateReadEvent stateReadEvent);

    void remove(StateReadEvent stateReadEvent);

    StateReadEvent find(Object id);

    List<StateReadEvent> findAll();

    List<StateReadEvent> findRange(int[] range);

    int count();
    
}

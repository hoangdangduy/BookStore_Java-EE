/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entities.WordSearch;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hoangdd
 */
@Local
public interface WordSearchFacadeLocal {

    void create(WordSearch wordSearch);

    void edit(WordSearch wordSearch);

    void remove(WordSearch wordSearch);

    WordSearch find(Object id);

    List<WordSearch> findAll();

    List<WordSearch> findRange(int[] range);

    int count();
    
}

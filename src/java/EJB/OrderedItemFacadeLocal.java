/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.OrderedItem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Aida
 */
@Local
public interface OrderedItemFacadeLocal {

    void create(OrderedItem orderedItem);

    void edit(OrderedItem orderedItem);

    void remove(OrderedItem orderedItem);

    OrderedItem find(Object id);

    List<OrderedItem> findAll();

    List<OrderedItem> findRange(int[] range);

    int count();
    
}

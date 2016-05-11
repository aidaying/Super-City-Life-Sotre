/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.OrderedItem;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Aida
 */
@Stateless
public class OrderedItemFacade extends AbstractFacade<OrderedItem> implements OrderedItemFacadeLocal {
    @PersistenceContext(unitName = "Super_City_Life_SotrePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderedItemFacade() {
        super(OrderedItem.class);
    }
    
}

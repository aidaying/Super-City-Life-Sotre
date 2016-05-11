package entity;

import entity.CustomerOrder;
import entity.Item;
import entity.OrderedItemPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-21T20:38:37")
@StaticMetamodel(OrderedItem.class)
public class OrderedItem_ { 

    public static volatile SingularAttribute<OrderedItem, Item> item;
    public static volatile SingularAttribute<OrderedItem, Short> quantity;
    public static volatile SingularAttribute<OrderedItem, OrderedItemPK> orderedItemPK;
    public static volatile SingularAttribute<OrderedItem, CustomerOrder> customerOrder;

}
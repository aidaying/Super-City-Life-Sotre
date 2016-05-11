package entity;

import entity.Category;
import entity.OrderedItem;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-04-21T20:38:37")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Integer> quantity;
    public static volatile SingularAttribute<Item, BigDecimal> price;
    public static volatile SingularAttribute<Item, Date> lastUpdate;
    public static volatile SingularAttribute<Item, String> name;
    public static volatile SingularAttribute<Item, String> description;
    public static volatile SingularAttribute<Item, Integer> id;
    public static volatile SingularAttribute<Item, String> type;
    public static volatile CollectionAttribute<Item, OrderedItem> orderedItemCollection;
    public static volatile SingularAttribute<Item, Category> categoryId;

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Aida
 */
@Entity
@Table(name = "ordered_item")
@NamedQueries({
    @NamedQuery(name = "OrderedItem.findAll", query = "SELECT o FROM OrderedItem o"),
    @NamedQuery(name = "OrderedItem.findByItemId", query = "SELECT o FROM OrderedItem o WHERE o.orderedItemPK.itemId = :itemId"),
    @NamedQuery(name = "OrderedItem.findByCustomerOrderId", query = "SELECT o FROM OrderedItem o WHERE o.orderedItemPK.customerOrderId = :customerOrderId"),
    @NamedQuery(name = "OrderedItem.findByQuantity", query = "SELECT o FROM OrderedItem o WHERE o.quantity = :quantity")})
public class OrderedItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderedItemPK orderedItemPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private short quantity;
    @JoinColumn(name = "customer_order_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CustomerOrder customerOrder;
    @JoinColumn(name = "item_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;

    public OrderedItem() {
    }

    public OrderedItem(OrderedItemPK orderedItemPK) {
        this.orderedItemPK = orderedItemPK;
    }

    public OrderedItem(OrderedItemPK orderedItemPK, short quantity) {
        this.orderedItemPK = orderedItemPK;
        this.quantity = quantity;
    }

    public OrderedItem(int itemId, int customerOrderId) {
        this.orderedItemPK = new OrderedItemPK(itemId, customerOrderId);
    }

    public OrderedItemPK getOrderedItemPK() {
        return orderedItemPK;
    }

    public void setOrderedItemPK(OrderedItemPK orderedItemPK) {
        this.orderedItemPK = orderedItemPK;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderedItemPK != null ? orderedItemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderedItem)) {
            return false;
        }
        OrderedItem other = (OrderedItem) object;
        if ((this.orderedItemPK == null && other.orderedItemPK != null) || (this.orderedItemPK != null && !this.orderedItemPK.equals(other.orderedItemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderedItem[ orderedItemPK=" + orderedItemPK + " ]";
    }
    
}

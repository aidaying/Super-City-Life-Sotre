/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Aida
 */
@Embeddable
public class OrderedItemPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "item_id")
    private int itemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customer_order_id")
    private int customerOrderId;

    public OrderedItemPK() {
    }

    public OrderedItemPK(int itemId, int customerOrderId) {
        this.itemId = itemId;
        this.customerOrderId = customerOrderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) itemId;
        hash += (int) customerOrderId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderedItemPK)) {
            return false;
        }
        OrderedItemPK other = (OrderedItemPK) object;
        if (this.itemId != other.itemId) {
            return false;
        }
        if (this.customerOrderId != other.customerOrderId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderedItemPK[ itemId=" + itemId + ", customerOrderId=" + customerOrderId + " ]";
    }
    
}

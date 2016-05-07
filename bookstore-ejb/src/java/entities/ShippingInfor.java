/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hoangdd
 */
@Entity
@Table(name = "ShippingInfor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShippingInfor.findAll", query = "SELECT s FROM ShippingInfor s"),
    @NamedQuery(name = "ShippingInfor.findByIdShippingInfor", query = "SELECT s FROM ShippingInfor s WHERE s.idShippingInfor = :idShippingInfor")})
public class ShippingInfor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idShippingInfor")
    private Integer idShippingInfor;
    @OneToMany(mappedBy = "idShippingInfor")
    private List<Orders> ordersList;
    @JoinColumn(name = "idCustomer", referencedColumnName = "idPerson")
    @ManyToOne
    private Customer idCustomer;
    @JoinColumn(name = "idAddressShipping", referencedColumnName = "idAddressShipping")
    @ManyToOne
    private AddressShipping idAddressShipping;

    public ShippingInfor() {
    }

    public ShippingInfor(Integer idShippingInfor) {
        this.idShippingInfor = idShippingInfor;
    }

    public Integer getIdShippingInfor() {
        return idShippingInfor;
    }

    public void setIdShippingInfor(Integer idShippingInfor) {
        this.idShippingInfor = idShippingInfor;
    }

    @XmlTransient
    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public AddressShipping getIdAddressShipping() {
        return idAddressShipping;
    }

    public void setIdAddressShipping(AddressShipping idAddressShipping) {
        this.idAddressShipping = idAddressShipping;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idShippingInfor != null ? idShippingInfor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingInfor)) {
            return false;
        }
        ShippingInfor other = (ShippingInfor) object;
        if ((this.idShippingInfor == null && other.idShippingInfor != null) || (this.idShippingInfor != null && !this.idShippingInfor.equals(other.idShippingInfor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ShippingInfor[ idShippingInfor=" + idShippingInfor + " ]";
    }
    
}

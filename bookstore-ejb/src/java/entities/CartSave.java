/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hoangdd
 */
@Entity
@Table(name = "CartSave")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartSave.findAll", query = "SELECT c FROM CartSave c"),
    @NamedQuery(name = "CartSave.findByIdCartSave", query = "SELECT c FROM CartSave c WHERE c.idCartSave = :idCartSave"),
    @NamedQuery(name = "CartSave.findByTotalPrice", query = "SELECT c FROM CartSave c WHERE c.totalPrice = :totalPrice")})
public class CartSave implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCartSave")
    private Integer idCartSave;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalPrice")
    private Double totalPrice;
    @JoinColumn(name = "idCustomerMember", referencedColumnName = "idPerson")
    @ManyToOne
    private CustomerMember idCustomerMember;
    @JoinColumn(name = "idCart", referencedColumnName = "idCart")
    @ManyToOne
    private Cart idCart;

    public CartSave() {
    }

    public CartSave(Integer idCartSave) {
        this.idCartSave = idCartSave;
    }

    public Integer getIdCartSave() {
        return idCartSave;
    }

    public void setIdCartSave(Integer idCartSave) {
        this.idCartSave = idCartSave;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CustomerMember getIdCustomerMember() {
        return idCustomerMember;
    }

    public void setIdCustomerMember(CustomerMember idCustomerMember) {
        this.idCustomerMember = idCustomerMember;
    }

    public Cart getIdCart() {
        return idCart;
    }

    public void setIdCart(Cart idCart) {
        this.idCart = idCart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCartSave != null ? idCartSave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartSave)) {
            return false;
        }
        CartSave other = (CartSave) object;
        if ((this.idCartSave == null && other.idCartSave != null) || (this.idCartSave != null && !this.idCartSave.equals(other.idCartSave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CartSave[ idCartSave=" + idCartSave + " ]";
    }
    
}

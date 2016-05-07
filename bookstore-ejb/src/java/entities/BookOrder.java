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
@Table(name = "BookOrder")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookOrder.findAll", query = "SELECT b FROM BookOrder b"),
    @NamedQuery(name = "BookOrder.findByIdBookOrder", query = "SELECT b FROM BookOrder b WHERE b.idBookOrder = :idBookOrder"),
    @NamedQuery(name = "BookOrder.findByQuantity", query = "SELECT b FROM BookOrder b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "BookOrder.findByTotalPrice", query = "SELECT b FROM BookOrder b WHERE b.totalPrice = :totalPrice")})
public class BookOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBookOrder")
    private Integer idBookOrder;
    @Column(name = "quantity")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalPrice")
    private Double totalPrice;
    @JoinColumn(name = "idCart", referencedColumnName = "idCart")
    @ManyToOne
    private Cart idCart;
    @JoinColumn(name = "idBook", referencedColumnName = "idBook")
    @ManyToOne(optional = false)
    private Book idBook;

    public BookOrder() {
    }

    public BookOrder(Integer idBookOrder) {
        this.idBookOrder = idBookOrder;
    }

    public Integer getIdBookOrder() {
        return idBookOrder;
    }

    public void setIdBookOrder(Integer idBookOrder) {
        this.idBookOrder = idBookOrder;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Cart getIdCart() {
        return idCart;
    }

    public void setIdCart(Cart idCart) {
        this.idCart = idCart;
    }

    public Book getIdBook() {
        return idBook;
    }

    public void setIdBook(Book idBook) {
        this.idBook = idBook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBookOrder != null ? idBookOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookOrder)) {
            return false;
        }
        BookOrder other = (BookOrder) object;
        if ((this.idBookOrder == null && other.idBookOrder != null) || (this.idBookOrder != null && !this.idBookOrder.equals(other.idBookOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BookOrder[ idBookOrder=" + idBookOrder + " ]";
    }
    
}

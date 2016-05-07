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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hoangdd
 */
@Entity
@Table(name = "CustomerMember")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerMember.findAll", query = "SELECT c FROM CustomerMember c"),
    @NamedQuery(name = "CustomerMember.findByIdPerson", query = "SELECT c FROM CustomerMember c WHERE c.idPerson = :idPerson"),
    @NamedQuery(name = "CustomerMember.findByUsername", query = "SELECT c FROM CustomerMember c WHERE c.username = :username"),
    @NamedQuery(name = "CustomerMember.findByPassword", query = "SELECT c FROM CustomerMember c WHERE c.password = :password"),
    @NamedQuery(name = "CustomerMember.findByIdKcoinBank", query = "SELECT c FROM CustomerMember c WHERE c.idKcoinBank = :idKcoinBank")})
public class CustomerMember implements Serializable {

    @OneToMany(mappedBy = "idCustomerMember")
    private List<CartSave> cartSaveList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idPerson")
    private Integer idPerson;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Column(name = "idKcoinBank")
    private Integer idKcoinBank;

    public CustomerMember() {
    }

    public CustomerMember(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public Integer getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Integer idPerson) {
        this.idPerson = idPerson;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdKcoinBank() {
        return idKcoinBank;
    }

    public void setIdKcoinBank(Integer idKcoinBank) {
        this.idKcoinBank = idKcoinBank;
    }

    public CustomerMember(Integer idPerson, String username, String password, Integer idKcoinBank) {
        this.idPerson = idPerson;
        this.username = username;
        this.password = password;
        this.idKcoinBank = idKcoinBank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerson != null ? idPerson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerMember)) {
            return false;
        }
        CustomerMember other = (CustomerMember) object;
        if ((this.idPerson == null && other.idPerson != null) || (this.idPerson != null && !this.idPerson.equals(other.idPerson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomerMember[ idPerson=" + idPerson + " ]";
    }

    @XmlTransient
    public List<CartSave> getCartSaveList() {
        return cartSaveList;
    }

    public void setCartSaveList(List<CartSave> cartSaveList) {
        this.cartSaveList = cartSaveList;
    }

}

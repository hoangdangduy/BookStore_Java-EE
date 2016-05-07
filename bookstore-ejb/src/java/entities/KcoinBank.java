/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hoangdd
 */
@Entity
@Table(name = "KcoinBank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KcoinBank.findAll", query = "SELECT k FROM KcoinBank k"),
    @NamedQuery(name = "KcoinBank.findByIdBank", query = "SELECT k FROM KcoinBank k WHERE k.idBank = :idBank")})
public class KcoinBank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBank")
    private Integer idBank;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "kcoinBank")
    private Bank bank;

    public KcoinBank() {
    }

    public KcoinBank(Integer idBank) {
        this.idBank = idBank;
    }

    public Integer getIdBank() {
        return idBank;
    }

    public void setIdBank(Integer idBank) {
        this.idBank = idBank;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBank != null ? idBank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KcoinBank)) {
            return false;
        }
        KcoinBank other = (KcoinBank) object;
        if ((this.idBank == null && other.idBank != null) || (this.idBank != null && !this.idBank.equals(other.idBank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.KcoinBank[ idBank=" + idBank + " ]";
    }
    
}

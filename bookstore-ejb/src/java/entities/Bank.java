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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "Bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
    @NamedQuery(name = "Bank.findByIdBank", query = "SELECT b FROM Bank b WHERE b.idBank = :idBank"),
    @NamedQuery(name = "Bank.findByBalance", query = "SELECT b FROM Bank b WHERE b.balance = :balance"),
    @NamedQuery(name = "Bank.findByPart", query = "SELECT b FROM Bank b WHERE b.part = :part")})
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBank")
    private Integer idBank;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private Double balance;
    @Size(max = 45)
    @Column(name = "part")
    private String part;
    @OneToMany(mappedBy = "idbank")
    private List<Payment> paymentList;
    @JoinColumn(name = "idBank", referencedColumnName = "idBank", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private KcoinBank kcoinBank;
    @JoinColumn(name = "idBank", referencedColumnName = "idBank", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private CardBank cardBank;

    public Bank() {
    }

    public Bank(Integer idBank) {
        this.idBank = idBank;
    }

    public Integer getIdBank() {
        return idBank;
    }

    public void setIdBank(Integer idBank) {
        this.idBank = idBank;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public KcoinBank getKcoinBank() {
        return kcoinBank;
    }

    public void setKcoinBank(KcoinBank kcoinBank) {
        this.kcoinBank = kcoinBank;
    }

    public CardBank getCardBank() {
        return cardBank;
    }

    public void setCardBank(CardBank cardBank) {
        this.cardBank = cardBank;
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
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.idBank == null && other.idBank != null) || (this.idBank != null && !this.idBank.equals(other.idBank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Bank[ idBank=" + idBank + " ]";
    }
    
}

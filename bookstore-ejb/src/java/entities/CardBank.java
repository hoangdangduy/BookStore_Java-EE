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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hoangdd
 */
@Entity
@Table(name = "CardBank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardBank.findAll", query = "SELECT c FROM CardBank c"),
    @NamedQuery(name = "CardBank.findByIdBank", query = "SELECT c FROM CardBank c WHERE c.idBank = :idBank"),
    @NamedQuery(name = "CardBank.findByCardtype", query = "SELECT c FROM CardBank c WHERE c.cardtype = :cardtype"),
    @NamedQuery(name = "CardBank.findByNameowner", query = "SELECT c FROM CardBank c WHERE c.nameowner = :nameowner"),
    @NamedQuery(name = "CardBank.findByNumcard", query = "SELECT c FROM CardBank c WHERE c.numcard = :numcard"),
    @NamedQuery(name = "CardBank.findByDateReissue", query = "SELECT c FROM CardBank c WHERE c.dateReissue = :dateReissue")})
public class CardBank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBank")
    private Integer idBank;
    @Size(max = 45)
    @Column(name = "cardtype")
    private String cardtype;
    @Size(max = 45)
    @Column(name = "nameowner")
    private String nameowner;
    @Size(max = 45)
    @Column(name = "numcard")
    private String numcard;
    @Size(max = 10)
    @Column(name = "dateReissue")
    private String dateReissue;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cardBank")
    private Bank bank;

    public CardBank() {
    }

    public CardBank(Integer idBank) {
        this.idBank = idBank;
    }

    public Integer getIdBank() {
        return idBank;
    }

    public void setIdBank(Integer idBank) {
        this.idBank = idBank;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getNameowner() {
        return nameowner;
    }

    public void setNameowner(String nameowner) {
        this.nameowner = nameowner;
    }

    public String getNumcard() {
        return numcard;
    }

    public void setNumcard(String numcard) {
        this.numcard = numcard;
    }

    public String getDateReissue() {
        return dateReissue;
    }

    public void setDateReissue(String dateReissue) {
        this.dateReissue = dateReissue;
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
        if (!(object instanceof CardBank)) {
            return false;
        }
        CardBank other = (CardBank) object;
        if ((this.idBank == null && other.idBank != null) || (this.idBank != null && !this.idBank.equals(other.idBank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CardBank[ idBank=" + idBank + " ]";
    }
    
}

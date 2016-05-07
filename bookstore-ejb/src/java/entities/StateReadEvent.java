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
@Table(name = "StateReadEvent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StateReadEvent.findAll", query = "SELECT s FROM StateReadEvent s"),
    @NamedQuery(name = "StateReadEvent.findByIdStateReadEvent", query = "SELECT s FROM StateReadEvent s WHERE s.idStateReadEvent = :idStateReadEvent"),
    @NamedQuery(name = "StateReadEvent.findByStateRead", query = "SELECT s FROM StateReadEvent s WHERE s.stateRead = :stateRead")})
public class StateReadEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idStateReadEvent")
    private Integer idStateReadEvent;
    @Column(name = "stateRead")
    private Boolean stateRead;
    @JoinColumn(name = "idEvent", referencedColumnName = "idEvent")
    @ManyToOne
    private Event idEvent;
    @JoinColumn(name = "idCustomerMember", referencedColumnName = "idPerson")
    @ManyToOne
    private CustomerMember idCustomerMember;

    public StateReadEvent() {
    }

    public StateReadEvent(Integer idStateReadEvent) {
        this.idStateReadEvent = idStateReadEvent;
    }

    public Integer getIdStateReadEvent() {
        return idStateReadEvent;
    }

    public void setIdStateReadEvent(Integer idStateReadEvent) {
        this.idStateReadEvent = idStateReadEvent;
    }

    public Boolean getStateRead() {
        return stateRead;
    }

    public void setStateRead(Boolean stateRead) {
        this.stateRead = stateRead;
    }

    public Event getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Event idEvent) {
        this.idEvent = idEvent;
    }

    public CustomerMember getIdCustomerMember() {
        return idCustomerMember;
    }

    public void setIdCustomerMember(CustomerMember idCustomerMember) {
        this.idCustomerMember = idCustomerMember;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStateReadEvent != null ? idStateReadEvent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateReadEvent)) {
            return false;
        }
        StateReadEvent other = (StateReadEvent) object;
        if ((this.idStateReadEvent == null && other.idStateReadEvent != null) || (this.idStateReadEvent != null && !this.idStateReadEvent.equals(other.idStateReadEvent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.StateReadEvent[ idStateReadEvent=" + idStateReadEvent + " ]";
    }
    
}

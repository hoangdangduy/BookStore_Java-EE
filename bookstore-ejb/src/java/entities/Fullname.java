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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hoangdd
 */
@Entity
@Table(name = "Fullname")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fullname.findAll", query = "SELECT f FROM Fullname f"),
    @NamedQuery(name = "Fullname.findByIdFullname", query = "SELECT f FROM Fullname f WHERE f.idFullname = :idFullname"),
    @NamedQuery(name = "Fullname.findByFname", query = "SELECT f FROM Fullname f WHERE f.fname = :fname"),
    @NamedQuery(name = "Fullname.findByMname", query = "SELECT f FROM Fullname f WHERE f.mname = :mname"),
    @NamedQuery(name = "Fullname.findByLname", query = "SELECT f FROM Fullname f WHERE f.lname = :lname")})
public class Fullname implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFullname")
    private Integer idFullname;
    @Size(max = 45)
    @Column(name = "fname")
    private String fname;
    @Size(max = 45)
    @Column(name = "mname")
    private String mname;
    @Size(max = 45)
    @Column(name = "lname")
    private String lname;

    public Fullname() {
    }

    public Fullname(Integer idFullname) {
        this.idFullname = idFullname;
    }

    public Integer getIdFullname() {
        return idFullname;
    }

    public void setIdFullname(Integer idFullname) {
        this.idFullname = idFullname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Fullname(Integer idFullname, String fname, String mname, String lname) {
        this.idFullname = idFullname;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFullname != null ? idFullname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fullname)) {
            return false;
        }
        Fullname other = (Fullname) object;
        if ((this.idFullname == null && other.idFullname != null) || (this.idFullname != null && !this.idFullname.equals(other.idFullname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Fullname[ idFullname=" + idFullname + " ]";
    }

}

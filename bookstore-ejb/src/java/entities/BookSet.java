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
@Table(name = "BookSet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookSet.findAll", query = "SELECT b FROM BookSet b"),
    @NamedQuery(name = "BookSet.findByIdBookSet", query = "SELECT b FROM BookSet b WHERE b.idBookSet = :idBookSet"),
    @NamedQuery(name = "BookSet.findByDescription", query = "SELECT b FROM BookSet b WHERE b.description = :description")})
public class BookSet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBookSet")
    private Integer idBookSet;
    @Size(max = 1000)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "idBookSet")
    private List<Book> bookList;

    public BookSet() {
    }

    public BookSet(Integer idBookSet) {
        this.idBookSet = idBookSet;
    }

    public Integer getIdBookSet() {
        return idBookSet;
    }

    public void setIdBookSet(Integer idBookSet) {
        this.idBookSet = idBookSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBookSet != null ? idBookSet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookSet)) {
            return false;
        }
        BookSet other = (BookSet) object;
        if ((this.idBookSet == null && other.idBookSet != null) || (this.idBookSet != null && !this.idBookSet.equals(other.idBookSet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.BookSet[ idBookSet=" + idBookSet + " ]";
    }
    
}

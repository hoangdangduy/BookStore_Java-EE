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
@Table(name = "WordSearch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WordSearch.findAll", query = "SELECT w FROM WordSearch w"),
    @NamedQuery(name = "WordSearch.findByIdWordSearch", query = "SELECT w FROM WordSearch w WHERE w.idWordSearch = :idWordSearch"),
    @NamedQuery(name = "WordSearch.findByContentSearch", query = "SELECT w FROM WordSearch w WHERE w.contentSearch = :contentSearch")})
public class WordSearch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idWordSearch")
    private Integer idWordSearch;
    @Size(max = 100)
    @Column(name = "contentSearch")
    private String contentSearch;

    public WordSearch() {
    }

    public WordSearch(Integer idWordSearch) {
        this.idWordSearch = idWordSearch;
    }

    public Integer getIdWordSearch() {
        return idWordSearch;
    }

    public void setIdWordSearch(Integer idWordSearch) {
        this.idWordSearch = idWordSearch;
    }

    public String getContentSearch() {
        return contentSearch;
    }

    public void setContentSearch(String contentSearch) {
        this.contentSearch = contentSearch;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWordSearch != null ? idWordSearch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WordSearch)) {
            return false;
        }
        WordSearch other = (WordSearch) object;
        if ((this.idWordSearch == null && other.idWordSearch != null) || (this.idWordSearch != null && !this.idWordSearch.equals(other.idWordSearch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.WordSearch[ idWordSearch=" + idWordSearch + " ]";
    }
    
}

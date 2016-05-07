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
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

/**
 *
 * @author hoangdd
 */
@Entity
@Table(name = "AddressShipping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressShipping.findAll", query = "SELECT a FROM AddressShipping a"),
    @NamedQuery(name = "AddressShipping.findByIdAddressShipping", query = "SELECT a FROM AddressShipping a WHERE a.idAddressShipping = :idAddressShipping"),
    @NamedQuery(name = "AddressShipping.findByNum", query = "SELECT a FROM AddressShipping a WHERE a.num = :num"),
    @NamedQuery(name = "AddressShipping.findByWard", query = "SELECT a FROM AddressShipping a WHERE a.ward = :ward"),
    @NamedQuery(name = "AddressShipping.findByDistric", query = "SELECT a FROM AddressShipping a WHERE a.distric = :distric"),
    @NamedQuery(name = "AddressShipping.findByCity", query = "SELECT a FROM AddressShipping a WHERE a.city = :city"),
    @NamedQuery(name = "AddressShipping.findByPhonePerson1", query = "SELECT a FROM AddressShipping a WHERE a.phonePerson1 = :phonePerson1"),
    @NamedQuery(name = "AddressShipping.findByNamePerson1", query = "SELECT a FROM AddressShipping a WHERE a.namePerson1 = :namePerson1"),
    @NamedQuery(name = "AddressShipping.findByPhonePerson2", query = "SELECT a FROM AddressShipping a WHERE a.phonePerson2 = :phonePerson2"),
    @NamedQuery(name = "AddressShipping.findByNamePerson2", query = "SELECT a FROM AddressShipping a WHERE a.namePerson2 = :namePerson2")})
public class AddressShipping implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAddressShipping")
    private Integer idAddressShipping;
    @Size(max = 45)
    @Column(name = "num")
    private String num;
    @Size(max = 45)
    @Column(name = "ward")
    private String ward;
    @Size(max = 45)
    @Column(name = "distric")
    private String distric;
    @Size(max = 45)
    @Column(name = "city")
    private String city;
    @Size(max = 45)
    @Column(name = "phonePerson1")
    private String phonePerson1;
    @Size(max = 45)
    @Column(name = "namePerson1")
    private String namePerson1;
    @Size(max = 45)
    @Column(name = "phonePerson2")
    private String phonePerson2;
    @Size(max = 45)
    @Column(name = "namePerson2")
    private String namePerson2;
    @OneToMany(mappedBy = "idAddressShipping")
    private List<ShippingInfor> shippingInforList;

    public AddressShipping() {
    }

    private AddressShipping(AddressShippingBuilder builder) {
        this.num = builder.num;
        this.ward = builder.ward;
        this.distric = builder.district;
        this.city = builder.city;
        this.phonePerson1 = builder.phonePerson1;
        this.namePerson1 = builder.namePerson1;
        this.phonePerson2 = builder.phonePerson2;
        this.namePerson2 = builder.phonePerson2;
    }

    public AddressShipping(Integer idAddressShipping) {
        this.idAddressShipping = idAddressShipping;
    }


    public Integer getIdAddressShipping() {
        return idAddressShipping;
    }

    public void setIdAddressShipping(Integer idAddressShipping) {
        this.idAddressShipping = idAddressShipping;
    }
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
    public String getDistric() {
        return distric;
    }

    public void setDistric(String distric) {
        this.distric = distric;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getPhonePerson1() {
        return phonePerson1;
    }

    public void setPhonePerson1(String phonePerson1) {
        this.phonePerson1 = phonePerson1;
    }
    public String getNamePerson1() {
        return namePerson1;
    }

    public void setNamePerson1(String namePerson1) {
        this.namePerson1 = namePerson1;
    }
    public String getPhonePerson2() {
        return phonePerson2;
    }

    public void setPhonePerson2(String phonePerson2) {
        this.phonePerson2 = phonePerson2;
    }
    public String getNamePerson2() {
        return namePerson2;
    }

    public void setNamePerson2(String namePerson2) {
        this.namePerson2 = namePerson2;
    }
    @XmlTransient
    public List<ShippingInfor> getShippingInforList() {
        return shippingInforList;
    }

    public void setShippingInforList(List<ShippingInfor> shippingInforList) {
        this.shippingInforList = shippingInforList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAddressShipping != null ? idAddressShipping.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressShipping)) {
            return false;
        }
        AddressShipping other = (AddressShipping) object;
        if ((this.idAddressShipping == null && other.idAddressShipping != null) || (this.idAddressShipping != null && !this.idAddressShipping.equals(other.idAddressShipping))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.AddressShipping[ idAddressShipping=" + idAddressShipping + " ]";
    }

    public static class AddressShippingBuilder {

        private String num;
        private String ward;
        private String district;
        private String city;
        private String phonePerson1;
        private String namePerson1;
        private String phonePerson2;
        private String namePerson2;

        public AddressShippingBuilder(String num, String ward, String district, String city, String namePerson1) {
            this.num = num;
            this.ward = ward;
            this.district = district;
            this.city = city;
            this.namePerson1 = namePerson1;
        }

        public AddressShippingBuilder phoneNumber1(String phoneNumber1) {
            this.phonePerson1 = phoneNumber1;
            return this;
        }

        public AddressShippingBuilder phoneNumber2(String phoneNumber2) {
            this.phonePerson2 = phoneNumber2;
            return this;
        }

        public AddressShippingBuilder namePerson2(String namePerson2) {
            this.namePerson2 = namePerson2;
            return this;
        }

        public AddressShipping build() {
            AddressShipping as = new AddressShipping(this);
            return as;
        }

    }

}

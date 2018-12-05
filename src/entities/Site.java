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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yudafatah
 */
@Entity
@Table(name = "SITE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s")
    , @NamedQuery(name = "Site.findBySiteId", query = "SELECT s FROM Site s WHERE s.siteId = :siteId")
    , @NamedQuery(name = "Site.findBySiteName", query = "SELECT s FROM Site s WHERE s.siteName = :siteName")
    , @NamedQuery(name = "Site.findByAddress", query = "SELECT s FROM Site s WHERE s.address = :address")})
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SITE_ID")
    private Integer siteId;
    @Column(name = "SITE_NAME")
    private String siteName;
    @Column(name = "ADDRESS")
    private String address;
    @OneToMany(mappedBy = "siteId", fetch = FetchType.LAZY)
    private List<Employee> employeeList;

    public Site() {
    }

    public Site(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siteId != null ? siteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.siteId == null && other.siteId != null) || (this.siteId != null && !this.siteId.equals(other.siteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Site[ siteId=" + siteId + " ]";
    }
    
}

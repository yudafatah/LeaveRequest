/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "LEAVE_REQUEST_TYPE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveRequestType.findAll", query = "SELECT l FROM LeaveRequestType l")
    , @NamedQuery(name = "LeaveRequestType.findByTypeLrId", query = "SELECT l FROM LeaveRequestType l WHERE l.typeLrId = :typeLrId")
    , @NamedQuery(name = "LeaveRequestType.findByTypeName", query = "SELECT l FROM LeaveRequestType l WHERE l.typeName = :typeName")
    , @NamedQuery(name = "LeaveRequestType.findByDurationLimit", query = "SELECT l FROM LeaveRequestType l WHERE l.durationLimit = :durationLimit")})
public class LeaveRequestType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TYPE_LR_ID")
    private Integer typeLrId;
    @Column(name = "TYPE_NAME")
    private String typeName;
    @Column(name = "DURATION_LIMIT")
    private Integer durationLimit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeLrId", fetch = FetchType.LAZY)
    private List<LeaveRequest> leaveRequestList;

    public LeaveRequestType() {
    }

    public LeaveRequestType(Integer typeLrId) {
        this.typeLrId = typeLrId;
    }

    public Integer getTypeLrId() {
        return typeLrId;
    }

    public void setTypeLrId(Integer typeLrId) {
        this.typeLrId = typeLrId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getDurationLimit() {
        return durationLimit;
    }

    public void setDurationLimit(Integer durationLimit) {
        this.durationLimit = durationLimit;
    }

    @XmlTransient
    public List<LeaveRequest> getLeaveRequestList() {
        return leaveRequestList;
    }

    public void setLeaveRequestList(List<LeaveRequest> leaveRequestList) {
        this.leaveRequestList = leaveRequestList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeLrId != null ? typeLrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeaveRequestType)) {
            return false;
        }
        LeaveRequestType other = (LeaveRequestType) object;
        if ((this.typeLrId == null && other.typeLrId != null) || (this.typeLrId != null && !this.typeLrId.equals(other.typeLrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LeaveRequestType[ typeLrId=" + typeLrId + " ]";
    }
    
}

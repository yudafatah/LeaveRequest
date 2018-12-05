/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yudafatah
 */
@Entity
@Table(name = "LEAVE_REQUEST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveRequest.findAll", query = "SELECT l FROM LeaveRequest l")
    , @NamedQuery(name = "LeaveRequest.findByLrId", query = "SELECT l FROM LeaveRequest l WHERE l.lrId = :lrId")
    , @NamedQuery(name = "LeaveRequest.findByRequestDate", query = "SELECT l FROM LeaveRequest l WHERE l.requestDate = :requestDate")
    , @NamedQuery(name = "LeaveRequest.findByStartDate", query = "SELECT l FROM LeaveRequest l WHERE l.startDate = :startDate")
    , @NamedQuery(name = "LeaveRequest.findByEndDate", query = "SELECT l FROM LeaveRequest l WHERE l.endDate = :endDate")
    , @NamedQuery(name = "LeaveRequest.findByLrDuration", query = "SELECT l FROM LeaveRequest l WHERE l.lrDuration = :lrDuration")
    , @NamedQuery(name = "LeaveRequest.findByNote", query = "SELECT l FROM LeaveRequest l WHERE l.note = :note")
    , @NamedQuery(name = "LeaveRequest.findByRequestStatus", query = "SELECT l FROM LeaveRequest l WHERE l.requestStatus = :requestStatus")
    , @NamedQuery(name = "LeaveRequest.findByDeleteStatus", query = "SELECT l FROM LeaveRequest l WHERE l.deleteStatus = :deleteStatus")})
public class LeaveRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LR_ID")
    private Integer lrId;
    @Column(name = "REQUEST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "LR_DURATION")
    private int lrDuration;
    @Column(name = "NOTE")
    private String note;
    @Basic(optional = false)
    @Column(name = "REQUEST_STATUS")
    private String requestStatus;
    @Column(name = "DELETE_STATUS")
    private String deleteStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lrId", fetch = FetchType.LAZY)
    private List<LeaveRequestHistory> leaveRequestHistoryList;
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "EMPLOYEE_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employeeId;
    @JoinColumn(name = "TYPE_LR_ID", referencedColumnName = "TYPE_LR_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LeaveRequestType typeLrId;

    public LeaveRequest() {
    }

    public LeaveRequest(Integer lrId) {
        this.lrId = lrId;
    }

    public LeaveRequest(Integer lrId, Date startDate, Date endDate, int lrDuration, String requestStatus) {
        this.lrId = lrId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lrDuration = lrDuration;
        this.requestStatus = requestStatus;
    }

    public Integer getLrId() {
        return lrId;
    }

    public void setLrId(Integer lrId) {
        this.lrId = lrId;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getLrDuration() {
        return lrDuration;
    }

    public void setLrDuration(int lrDuration) {
        this.lrDuration = lrDuration;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @XmlTransient
    public List<LeaveRequestHistory> getLeaveRequestHistoryList() {
        return leaveRequestHistoryList;
    }

    public void setLeaveRequestHistoryList(List<LeaveRequestHistory> leaveRequestHistoryList) {
        this.leaveRequestHistoryList = leaveRequestHistoryList;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public LeaveRequestType getTypeLrId() {
        return typeLrId;
    }

    public void setTypeLrId(LeaveRequestType typeLrId) {
        this.typeLrId = typeLrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lrId != null ? lrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeaveRequest)) {
            return false;
        }
        LeaveRequest other = (LeaveRequest) object;
        if ((this.lrId == null && other.lrId != null) || (this.lrId != null && !this.lrId.equals(other.lrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LeaveRequest[ lrId=" + lrId + " ]";
    }
    
}

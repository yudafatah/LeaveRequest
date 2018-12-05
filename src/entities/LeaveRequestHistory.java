/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yudafatah
 */
@Entity
@Table(name = "LEAVE_REQUEST_HISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LeaveRequestHistory.findAll", query = "SELECT l FROM LeaveRequestHistory l")
    , @NamedQuery(name = "LeaveRequestHistory.findByLrHistoryId", query = "SELECT l FROM LeaveRequestHistory l WHERE l.lrHistoryId = :lrHistoryId")
    , @NamedQuery(name = "LeaveRequestHistory.findByValidDate", query = "SELECT l FROM LeaveRequestHistory l WHERE l.validDate = :validDate")
    , @NamedQuery(name = "LeaveRequestHistory.findByValidDuration", query = "SELECT l FROM LeaveRequestHistory l WHERE l.validDuration = :validDuration")
    , @NamedQuery(name = "LeaveRequestHistory.findByStartDate", query = "SELECT l FROM LeaveRequestHistory l WHERE l.startDate = :startDate")
    , @NamedQuery(name = "LeaveRequestHistory.findByEndDate", query = "SELECT l FROM LeaveRequestHistory l WHERE l.endDate = :endDate")
    , @NamedQuery(name = "LeaveRequestHistory.findByNote", query = "SELECT l FROM LeaveRequestHistory l WHERE l.note = :note")})
public class LeaveRequestHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LR_HISTORY_ID")
    private Integer lrHistoryId;
    @Column(name = "VALID_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validDate;
    @Basic(optional = false)
    @Column(name = "VALID_DURATION")
    private int validDuration;
    @Basic(optional = false)
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "NOTE")
    private String note;
    @JoinColumn(name = "LR_ID", referencedColumnName = "LR_ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LeaveRequest lrId;

    public LeaveRequestHistory() {
    }

    public LeaveRequestHistory(Integer lrHistoryId) {
        this.lrHistoryId = lrHistoryId;
    }

    public LeaveRequestHistory(Integer lrHistoryId, int validDuration, Date startDate, Date endDate) {
        this.lrHistoryId = lrHistoryId;
        this.validDuration = validDuration;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getLrHistoryId() {
        return lrHistoryId;
    }

    public void setLrHistoryId(Integer lrHistoryId) {
        this.lrHistoryId = lrHistoryId;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public int getValidDuration() {
        return validDuration;
    }

    public void setValidDuration(int validDuration) {
        this.validDuration = validDuration;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LeaveRequest getLrId() {
        return lrId;
    }

    public void setLrId(LeaveRequest lrId) {
        this.lrId = lrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lrHistoryId != null ? lrHistoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeaveRequestHistory)) {
            return false;
        }
        LeaveRequestHistory other = (LeaveRequestHistory) object;
        if ((this.lrHistoryId == null && other.lrHistoryId != null) || (this.lrHistoryId != null && !this.lrHistoryId.equals(other.lrHistoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.LeaveRequestHistory[ lrHistoryId=" + lrHistoryId + " ]";
    }
    
}

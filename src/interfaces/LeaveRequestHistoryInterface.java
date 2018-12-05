/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Date;
import java.util.List;

/**
 *
 * @author EMDES
 */
public interface LeaveRequestHistoryInterface {

    /**
     *
     * @param entity
     * @param keywoard
     * @return
     */
    public List<Object> getAlls(Object entity, String keywoard);

    /**
     *
     * @param id
     * @param lrId
     * @param validDate
     * @param startDate
     * @param endDate
     * @param note
     * @return
     */
    public String insert (String id, String lrId, Date validDate, Date startDate, Date endDate, String note);
}

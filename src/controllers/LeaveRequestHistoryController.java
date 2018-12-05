/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import interfaces.DAOInterface;
import daos.GeneralDAO;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import interfaces.LeaveRequestHistoryInterface;

/**
 *
 * @author EMDES
 */
public class LeaveRequestHistoryController implements LeaveRequestHistoryInterface {

    private DAOInterface gdao;

    /**
     *
     * @param factory
     */
    public LeaveRequestHistoryController(SessionFactory factory) {
        this.gdao = new GeneralDAO(factory);
    }

    /**
     *
     */
    public LeaveRequestHistoryController() {
    }

    @Override
    public List<Object> getAlls(Object entity, String keywoard) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(String id, String lrId, Date validDate, Date startDate, Date endDate, String note) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

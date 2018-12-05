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
import interfaces.EmployeeInterface;

/**
 *
 * @author EMDES
 */
public class EmployeeController implements EmployeeInterface {

    private DAOInterface gdao;
    
    /**
     *
     * @param factory
     */
    public EmployeeController(SessionFactory factory) {
        this.gdao = new GeneralDAO(factory);
    }

    /**
     *
     */
    public EmployeeController() {
    }
                
    @Override
    public List<Object> getAlls(Object entity, String keyword) {
        return gdao.doDDL(entity, "");
    }

    @Override
    public String update(String id, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insert(String id, String name, String gender, String addres, Date joinDate, String email, String managerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

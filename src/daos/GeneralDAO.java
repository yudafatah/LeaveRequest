/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import interfaces.DAOInterface;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author yudafatah
 */
public class GeneralDAO implements DAOInterface{
    FunctionDAO fdao;

    public GeneralDAO() {
    }

    public GeneralDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }
    
    public boolean login(String username, String password){
        return this.fdao.login(username, password);
    }
    @Override
    public boolean doDML(Object object, boolean isDelete) {
        return this.fdao.insertOrUpdateOrDelete(object, isDelete);
    }
    /**
     * 
     * @param data
     * @param table
     * @param obj
     * @param searchBy
     * @return 
     */
    @Override
    public List<Object> doDDL(Object table, String keyword) {
        return this.fdao.getDatas(table, keyword);
    }
    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public Object getById(Object entity,Object id) {
        return this.fdao.getById(entity,id);
    }
}

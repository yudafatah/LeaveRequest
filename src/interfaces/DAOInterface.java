/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;

/**
 *
 * @author yudafatah
 */
public interface DAOInterface {
    public boolean login(String username, String password);
    public boolean doDML(Object object, boolean isDelete);//iud
    public List<Object> doDDL(Object table, String keyword);//sga
    public Object getById(Object entity,Object id);
    
}

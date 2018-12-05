/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import interfaces.DAOInterface;
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
}

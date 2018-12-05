/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import interfaces.AccountInterface;
import interfaces.DAOInterface;
import org.hibernate.SessionFactory;

/**
 *
 * @author yudafatah
 */
public class AccountController implements AccountInterface{
    DAOInterface daoi;

    public AccountController() {
    }

    public AccountController(SessionFactory factory) {
        this.daoi = new GeneralDAO(factory);
    }
    public String login(String username, String password){
        if(daoi.login(username, password)){
            return "Welcome "+ username + ", Login succes";
        }else{
            return "Login failed!";
        }
    }
}

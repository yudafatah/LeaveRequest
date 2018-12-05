/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Account;
import helper.BCrypt;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author yudafatah
 */
public class FunctionDAO {
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public FunctionDAO() {
    }

    public FunctionDAO(SessionFactory factory) {
        this.factory = factory;
    }
    
    /**
     * Fungsi untuk melakukan insert, update atau delete 
     * @param Object 
     * @param isDelete boolean true for delete false for update or insert
     * @return 
     */
    public boolean insertOrUpdateOrDelete(Object object, 
            boolean isDelete){
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (isDelete) {
                session.delete(object);
            }else{
                session.saveOrUpdate(object);
            }
            result = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction!=null) transaction.rollback();
        } finally {
            session.close();
        }
        return result;
    }
    
    /**
     * 
     * @param query
     * @return 
     */
    public List<Object> getDatas(Object entities, String key) {
        List<Object> rs = new ArrayList<>();
        String className = entities.getClass().getName();
        
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "From " + className + " ORDER BY 1 ";
        System.out.println(className);
        if (!key.equals("")) {
            query = getQuery(entities, key);
        }
        System.out.println(query);
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            rs = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }
    
    public String getQuery(Object entity, String key) {
        String className = entity.getClass().getSimpleName();
        className = className.substring(className.lastIndexOf(".") + 1);
        String query = "FROM "+className+" WHERE ";
        for (Object r : entity.getClass().getDeclaredFields()) {
            String field = r + "";
            if (!field.contains("UID") && !field.contains("List")) {
                field = field.substring(field.lastIndexOf(".") + 1);
                query += field + " LIKE '%" + key + "%' OR ";
            }
        }
        query = query.substring(0, query.lastIndexOf("OR")) + " ORDER BY 1";

        return query;
    }
    
    /**
     * 
     * @param query
     * @return 
     */
    public Object getById(Object entity, Object id){
        Object object = new Object();
        String className = entity.getClass().getSimpleName();
        String query = className.toLowerCase() +"Id";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            object = session.createQuery("FROM "+ entity.getClass().getSimpleName() 
                    +" WHERE "+query+" ="+id)
                    .uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction!=null)transaction.rollback();
        } finally {
            session.close();
        }
        return object;
    }
    /**
     * to find password by username
     * @param entity Object table
     * @param username username of account
     * @return 
     */
    private Account find(String username){
        Account account = null;
        session = factory.openSession();
        transaction =null;
        try {
            transaction = session.beginTransaction();
            account = (Account) session.createQuery("FROM Account WHERE"
                    + " username = :username").setString("username", username).uniqueResult();
            transaction.commit();
            //System.out.println(account);
        } catch (Exception e) {
            account = null;
            if(transaction!=null){
                transaction.rollback();
            }
        }finally{
            session.close();
        }
        return account;
    }
    public boolean login(String username, String password){
        boolean result = false;
        Account account = this.find(username);
        System.out.println(account+"bbbb");
        if (account != null){
            System.out.println("cc");
            if(BCrypt.checkpw(password, account.getPassword())){
                result = true;
                System.out.println("berhasil");
            }
        }
        return result;
    }
}

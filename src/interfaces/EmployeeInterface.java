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
public interface EmployeeInterface {

    /**
     *
     * @param entity
     * @param keyword
     * @return
     */
    public List<Object> getAlls(Object entity, String keyword);

   /**
    * 
    * @param id
    * @param name
    * @param gender
    * @param addres
    * @param joinDate
    * @param email
    * @param managerId
    * @return 
    */
    public String insert (String id, String name, String gender, String addres, Date joinDate, String email, String managerId);

    /**
     *
     * @param id
     * @param name
     * @return
     */
    public String update (String id, String name);

//    /**
//     *
//     * @param id
//     * @return
//     */
//    public String delete (String id);
}
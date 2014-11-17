/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.teacher;

import com.tm.entities.Teacher;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sunil
 */
@Stateless
public class TeacherBean implements TeacherBeanLocal {

    @PersistenceContext(unitName = "tmReservation")
    private EntityManager em;
    
    @Override
    public List<Teacher> getTeacherList() {
        try {
            List<Teacher> teachers = new ArrayList<>();
            System.out.println(">>IN EJB::");
            Query query = em.createNamedQuery("Teacher.findAll");
            System.out.println("IN TEACHER>>");
            teachers = query.getResultList();
            System.out.println("TEST IS " + teachers.size());
              return teachers;
        } catch (Exception e) {
            return null;
        }
    }

   

}

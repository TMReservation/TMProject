/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.student;

import com.tm.entities.Student;
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
public class StudentBean implements StudentBeanLocal {

   @PersistenceContext(unitName = "tmReservation")
    private EntityManager em;
    
    @Override
    public List<Student> getStudentList() {
        try {
            List<Student> students = new ArrayList<>();
            System.out.println(">>IN EJB::");
            Query query = em.createNamedQuery("Student.findAll");
            System.out.println("IN Student>>");
            students = query.getResultList();
            System.out.println("TEST IS " + students.size());
              return students;
        } catch (Exception e) {
            return null;
        }
    }
}

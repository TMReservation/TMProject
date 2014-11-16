/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.bean;

import com.tm.entities.Test;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sunil
 */
@Stateless
public class First implements FirstLocal {

    @PersistenceContext(unitName = "tmReservation")
    private EntityManager em;

    @PreDestroy
    public void destruct() {
        em.close();
    }

    @Override
    public List<Test> getAllProjectTest() {
        try {
            List<Test> test = new ArrayList<>();
            System.out.println(">>IN EJB");
            Query query = em.createNamedQuery("Test.findAll");
            test = query.getResultList();
            System.out.println("TEST IS " + test.size());
              return test;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}

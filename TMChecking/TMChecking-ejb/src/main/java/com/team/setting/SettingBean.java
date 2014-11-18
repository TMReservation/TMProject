/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.setting;

import com.tm.entities.Setting;
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
public class SettingBean implements SettingBeanLocal {
    
    @PersistenceContext(unitName = "tmReservation")
    private EntityManager em;

    @Override
    public List<Setting> getSettingList() {
        try {
            List<Setting> settings = new ArrayList<>();
            System.out.println(">>IN SETTING::");
            Query query = em.createNamedQuery("Setting.findAll");
            System.out.println("IN TEACHER>>");
            settings = query.getResultList();
            System.out.println("TEST IS " + settings.size());
              return settings;
        } catch (Exception e) {
            return null;
        }
          }
    

}

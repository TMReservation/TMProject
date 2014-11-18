/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.setting;

import com.tm.entities.Setting;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author sunil
 */
@ManagedBean(name = "settingBean")
@SessionScoped
public class SettingBean implements Serializable{
   // @EJB
   // private SettingBeanLocal settingBeanLocal;
    List<Setting> settings=new ArrayList<>();
    private int currentSettingIndex;
    private Setting setting;
    
    public String showSettingList(){
        System.out.println("IN SETTING BEAN");
        //settings=settingBeanLocal.getSettingList();
        //settings=settingLocal.getSettingRole();
       // System.out.println("Teacher size is "+settings.size());
        return "setting";
    }
    
     public void store() {
        settings.set(currentSettingIndex, setting);
    }

    public List<Setting> getSettings() {
        return settings;
    }

    public void setSettings(List<Setting> settings) {
        this.settings = settings;
    }

    public int getCurrentSettingIndex() {
        return currentSettingIndex;
    }

    public void setCurrentSettingIndex(int currentSettingIndex) {
        this.currentSettingIndex = currentSettingIndex;
    }

    public Setting getSetting() {
       // System.out.println("HIT SETTING BEAN "+setting.getId());
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }
    
    
}

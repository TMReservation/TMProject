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
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sunil
 */
@ManagedBean(name = "settingBean")
@SessionScoped
public class SettingBean implements Serializable{  
    List<Setting> settings=new ArrayList<>();
    private int currentSettingIndex;
    private Setting setting;
    private SettingDB settingDB=new SettingDB();
    
  
    public String showSettingList(){               
        settings=settingDB.getSettingList();
        return "setting";
    }
    
    public String checkUpdateSetting(){
        System.out.println("Inside update "+setting.getId());
        
        return "";
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
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }
    
    
}

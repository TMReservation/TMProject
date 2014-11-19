/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mum.teacher;

/**
 *
 * @author sunil
 */

import org.richfaces.model.CalendarDataModelItem;


public class CalendarModelItem implements CalendarDataModelItem {
    private boolean enabled;
    private String styleClass;
 
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
 
    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }
 
    @Override
    public boolean isEnabled() {
        return enabled;
    }
 
    @Override
    public String getStyleClass() {
        return styleClass;
    }
 
    @Override
    public Object getData() {
        return null;
    }
 
    public boolean hasToolTip() {
        // TODO Auto-generated method stub
        return false;
    }
 
    public Object getToolTip() {
        // TODO Auto-generated method stub
        return null;
    }
 
    public int getDay() {
        return 0;
    }
}

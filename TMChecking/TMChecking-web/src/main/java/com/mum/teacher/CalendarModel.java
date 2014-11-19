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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.richfaces.model.CalendarDataModel;
import org.richfaces.model.CalendarDataModelItem;

@ManagedBean
@ApplicationScoped
public class CalendarModel implements CalendarDataModel {

    private static final String WEEKEND_DAY_CLASS = "wdc";
    private static final String BUSY_DAY_CLASS = "bdc";
    private static final String BOUNDARY_DAY_CLASS = "rf-ca-boundary-dates";

   

   
    
   
    private boolean checkBusyDay(Calendar calendar) {
        System.out.println("CheckBusy "+calendar);
        return (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY);
    }

    private boolean checkWeekend(Calendar calendar) {
          System.out.println("check weekend "+calendar);
        return (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY);
    }

    @Override
    public CalendarDataModelItem[] getData(Date[] dateArray) {
        System.out.println("Click select item>>>>>> "+dateArray);
        
        CalendarDataModelItem[] modelItems = new CalendarModelItem[dateArray.length];
        Calendar current = GregorianCalendar.getInstance();
        Calendar today = GregorianCalendar.getInstance();
        System.out.println("TODAY "+current);
        today.setTime(new Date());
        for (int i = 0; i < dateArray.length; i++) {
           
            current.setTime(dateArray[i]);
            CalendarModelItem modelItem = new CalendarModelItem();
            if (current.before(today)) {
                
                modelItem.setEnabled(false);
                modelItem.setStyleClass(BOUNDARY_DAY_CLASS);
            } else if (checkBusyDay(current)) {
                modelItem.setEnabled(false);
                modelItem.setStyleClass(BUSY_DAY_CLASS);
            } else if (checkWeekend(current)) {
                modelItem.setEnabled(false);
                modelItem.setStyleClass(WEEKEND_DAY_CLASS);
            } else {
                 System.out.println("DATE IS>> "+dateArray[i]);
                modelItem.setEnabled(true);
                modelItem.setStyleClass("");
            }
            modelItems[i] = modelItem;
        }
        System.out.println("MODEL ITEM "+modelItems);
        return modelItems;
    }

    @Override
    public Object getToolTip(Date date) {
        System.out.println("DATE OBJECT "+date);
        return null;
    }
}

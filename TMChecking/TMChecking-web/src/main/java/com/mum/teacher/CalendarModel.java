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
import com.mum.setting.TeacherDB;
import com.tm.entities.Teacher;
import com.tmchecking.UserBean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.richfaces.model.CalendarDataModel;
import org.richfaces.model.CalendarDataModelItem;

@ManagedBean
@ApplicationScoped
public class CalendarModel implements CalendarDataModel {

    private static final String WEEKEND_DAY_CLASS = "wdc";
    private static final String BUSY_DAY_CLASS = "bdc";
    private static final String BOUNDARY_DAY_CLASS = "rf-ca-boundary-dates";
    private Date currentDate;
    private String selectTeacherId;
    private boolean enabledTM;
    private ArrayList<SelectItem> selectTeacherList = new ArrayList<>();
    List<Teacher> teachers = new ArrayList<>();
    TeacherDB teacherDB = new TeacherDB();
    private Map<Integer, String> availableItems; 

    public Map<Integer, String> getAvailableItems() {
        return availableItems;
    }

    public void setAvailableItems(Map<Integer, String> availableItems) {
        this.availableItems = availableItems;
    }

    
    

    public String addAppointmentStudent() {
        availableItems = new LinkedHashMap<Integer, String>();
        SelectItem teacherItem = new SelectItem();
        teachers = new ArrayList<>();
        teachers = teacherDB.getTeacherList();
        selectTeacherList = new ArrayList<SelectItem>();
        for (Teacher t : teachers) {
            availableItems.put(t.getId(), t.getFirstName() + t.getLastName());
            teacherItem = new SelectItem(t.getId(), t.getFirstName() + t.getLastName());
            selectTeacherList.add(teacherItem);
        }
        
        return "addAppointmentStudent";
    }
     public void valueChangedForTeacher(AjaxBehaviorEvent event) {
        System.out.println("EVENT  " + event);
        System.out.println("User ID IS " + selectTeacherId);
    }

    private boolean checkBusyDay(Calendar calendar) {
        return (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY);
    }

    private boolean checkWeekend(Calendar calendar) {
        return (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY);
    }

    @Override
    public CalendarDataModelItem[] getData(Date[] dateArray) {
        CalendarDataModelItem[] modelItems = new CalendarModelItem[dateArray.length];
        Calendar current = GregorianCalendar.getInstance();
        Calendar today = GregorianCalendar.getInstance();
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
                modelItem.setEnabled(true);
                modelItem.setStyleClass("");
            }
            modelItems[i] = modelItem;
        }
        return modelItems;
    }

    public String addTMCheckingSchedule() {      
        int studentId=9;
        int pending=0;
        int enable=0;
        if(enabledTM==true){
            enable=1;
        }else{
            enable=0;
        }
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        System.out.println("NAME IS "+session.getAttribute("chosenUsername"));
        System.out.println(">>>>>>");
        boolean checkTMStatus=teacherDB.saveTMChecking(currentDate,selectTeacherId,studentId,enable,pending);
        if(checkTMStatus==true){
            selectTeacherId="";
        }else{
            
        }
        return "";
    }

    @Override
    public Object getToolTip(Date date) {
        return null;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public String getSelectTeacherId() {
        return selectTeacherId;
    }

    public void setSelectTeacherId(String selectTeacherId) {
        this.selectTeacherId = selectTeacherId;
    }

   

    public boolean isEnabledTM() {
        return enabledTM;
    }

    public void setEnabledTM(boolean enabledTM) {
        this.enabledTM = enabledTM;
    }

    public ArrayList<SelectItem> getSelectTeacherList() {
        return selectTeacherList;
    }

    public void setSelectTeacherList(ArrayList<SelectItem> selectTeacherList) {
        this.selectTeacherList = selectTeacherList;
    }
    

}

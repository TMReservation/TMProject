/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmchecking;

//import com.team.bean.FirstLocal;
import com.database.connection.DatabaseSetting;
import com.tm.entities.Login;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sunil
 */
@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {

    boolean showIT = false;
    boolean showStudent = false;
    boolean showTeacher = false;
    private String username = "";
    private String password = "";
    private String msg = "";
    private boolean disabledHeader = false;
    private String userTypes = "";
    Login login = new Login();
    private int id;

    public void logout() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.invalidateSession();
        ec.redirect(ec.getRequestContextPath() + "/index.xhtml");
    }

    public String checkLogin() {
        System.out.println("User type is " + userTypes);
        msg = "";
        if (userTypes.equalsIgnoreCase("select")) {
            msg = "Please,select types";
            return "index";
        }
        DatabaseSetting databaseSetting = new DatabaseSetting();
        String checkLoginStatus = databaseSetting.checkLogin(username, password, userTypes);

        System.out.println("login name is " + databaseSetting.getUsername());
        System.out.println("checklogin name is " + checkLoginStatus);
        if (databaseSetting.getUsername() != null) {
            username = databaseSetting.getUsername();

            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("chosenUsername", username);
            System.out.println("NAME IS "+session.getAttribute("chosenUsername"));
            
           

//            FacesContext facesContext = FacesContext.getCurrentInstance();
//            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
//            Enumeration e = session.getAttributeNames();
//            while (e.hasMoreElements()) {
//                String attr = (String) e.nextElement();
//                System.err.println("      attr  = " + attr);
//                Object value = session.getValue(attr);
//                System.err.println("      value = " + value);
//            }
            id = databaseSetting.getId();
            if (checkLoginStatus.equalsIgnoreCase("student")) {
                showStudent = true;
                showIT = false;
                showTeacher = false;
            } else if (checkLoginStatus.equalsIgnoreCase("teacher")) {
                showStudent = false;
                showIT = false;
                showTeacher = true;
            } else if (checkLoginStatus.equalsIgnoreCase("it")) {
                showStudent = true;
                showIT = true;
                showTeacher = true;
            } else {
                msg = "Invalid username and password";
                return "index";
            }
        } else {
            msg = "Invalid username and password";
            return "index";
        }

        msg = "";
        disabledHeader = true;
        return "home";
    }

    public String settingPage() {
        return "setting";
    }

    public String redirectHomePage() {
        return "index";
    }

    public boolean isShowIT() {
        return showIT;
    }

    public void setShowIT(boolean showIT) {
        this.showIT = showIT;
    }

    public boolean isShowStudent() {
        return showStudent;
    }

    public void setShowStudent(boolean showStudent) {
        this.showStudent = showStudent;
    }

    public boolean isShowTeacher() {
        return showTeacher;
    }

    public void setShowTeacher(boolean showTeacher) {
        this.showTeacher = showTeacher;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

    public boolean isDisabledHeader() {
        return disabledHeader;
    }

    public void setDisabledHeader(boolean disabledHeader) {
        this.disabledHeader = disabledHeader;
    }

    public String getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(String userTypes) {
        this.userTypes = userTypes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.bean;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sunil
 */
@Local
public interface SettingLocal {
    public List<Setting> getStudentList();
}

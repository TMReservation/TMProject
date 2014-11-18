/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team.setting;

import com.tm.entities.Setting;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sunil
 */
@Local
public interface SettingBeanLocal {
      public List<Setting> getSettingList();
}

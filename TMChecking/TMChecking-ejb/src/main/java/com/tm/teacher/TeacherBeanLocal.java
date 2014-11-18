/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tm.teacher;

import com.tm.entities.Teacher;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sunil
 */
@Local
public interface TeacherBeanLocal {
    public List<Teacher> getTeacherList();
    public boolean addTeacherInfo(Teacher teacher);
}

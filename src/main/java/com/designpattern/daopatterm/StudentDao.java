package com.designpattern.daopatterm;

import java.util.List;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:35 2018/2/23
 */
public interface StudentDao {
    public List<Student> getAllStudents();

    public Student getStudent(int rollNo);

    public void updateStudent(Student student);

    public void deleteStudent(Student student);
}

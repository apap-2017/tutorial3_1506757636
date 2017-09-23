package com.example.tutorial3.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.tutorial3.model.StudentModel;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentService implements StudentService {
    private static List<StudentModel> studentList = new ArrayList<StudentModel>();

    @Override
    public StudentModel selectStudent(String npm) {
        StudentModel student = studentList.get(0);
        for (int i = 0; i < studentList.size(); i++) {
            if(student.getNpm().equals(npm)) {
                student = studentList.get(i);
            } else {
                student = null;
            }
        }
        return student;
    }

    @Override
    public List<StudentModel> selectAllStudents() {
        return studentList;
    }

    @Override
    public void addStudent(StudentModel student) {
        studentList.add(student);
    }

    @Override
    public StudentModel deleteStudent(String npm) {
        StudentModel student = studentList.get(0);
        for (int i = 0; i < studentList.size(); i++) {
            if(student.getNpm().equals(npm)) {
                student = studentList.get(i);
                studentList.remove(student);
            } else {
                student = null;
            }
        }
        return student;
    }
}

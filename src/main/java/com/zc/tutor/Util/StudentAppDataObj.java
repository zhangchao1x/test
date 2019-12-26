package com.zc.tutor.Util;

import com.zc.tutor.Common.Result.ResultCode;
import com.zc.tutor.Entity.Student;
import com.zc.tutor.Entity.Teacher;
import com.zc.tutor.Repository.StudentRep;
import com.zc.tutor.Repository.TeacherRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.zc.tutor.Util
 * @ClassName StudentAppDateObj
 * @Author Lucas
 * @Date 9/20/2019 7:47 PM
 **/
public class StudentAppDataObj {

    @Autowired
    StudentRep studentRep;

    Student student = new Student();
    List<Student> listStudent = new ArrayList<>();

    public boolean IsFetchStudent(Integer id){
        ServiceUtilities.InitializeObject(student);
        student = studentRep.findByStuId(id);
        if (student.getStuId() != null) return true;
        else return false;
    }

    public Student FetchStudentByPhone(String phone){
        ServiceUtilities.InitializeObject(student);
        student = studentRep.findByPhone(phone);
        if(student.getStuId() != null){
            return student;
        }else{
            throw new Error(ResultCode.USER_UPDATE_PHONE_NOT_EXIST.getMsg());
        }
    }

    public Student FetchStudentObjectById(Integer id){
    ServiceUtilities.InitializeObject(student);
    student = studentRep.findByStuId(id);
        if (student.getStuId() != null) {
            return student;
        }else{
            throw new Error(ResultCode.FIND_STUDENT_FAILED.getMsg());
        }
    }

    public Student FetchStudentObjectByPhone(Integer id, String phone){
        ServiceUtilities.InitializeObject(student);
        student = studentRep.findByPhoneAndStuId(id, phone);
        if(student.getStuId() != null) {
            return student;
        }else{
            throw new Error(ResultCode.FIND_STUDENT_FAILED.getMsg());
        }
    }

    public List<Student> FetchStudentObject(){
        listStudent.clear();
        listStudent = studentRep.findAll();
        if(listStudent.isEmpty() != true) {
            return listStudent;
        }else{
            throw new Error(ResultCode.FIND_STUDENT_FAILED.getMsg());
        }
    }

    public boolean SaveStudent(Student student) {
        studentRep.save(student);
        if (IsFetchStudent(student.getStuId())){
            return true;
        }else{
            throw new Error(ResultCode.USER_SAVE_FAILED.getMsg());
        }
    }

}

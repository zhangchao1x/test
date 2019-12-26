package com.zc.tutor.Service.SerImp;

import com.zc.tutor.Common.Result.Result;
import com.zc.tutor.Common.Result.ResultCode;
import com.zc.tutor.Entity.Student;
import com.zc.tutor.Service.UserService;
import com.zc.tutor.Util.ServiceUtilities;
import com.zc.tutor.Util.StudentAppDataObj;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    StudentAppDataObj studentAppDataObj;

    List<Student> listStudent = new ArrayList<>();
    Student student = new Student();

    @Override
    @Transactional
    public Result UpdateInfo(Student student) {
        if (studentAppDataObj.FetchStudentObjectByPhone(student.getStuId(), student.getPhone()).getStuId() != null) {
            return Result.error(ResultCode.USER_UPDATE_PHONE_EXIST, student);
        }
        if (ServiceUtilities.isMobileNO(student.getPhone())) {
            if (student.getPassword().length() > 16) {
                return Result.error(ResultCode.USER_UPDATE_PASSWODR_FAIL, student);
            }
            try {
                return Result.success(ResultCode.SUCCESS, studentAppDataObj.SaveStudent(student));
            } catch (Error e) {
                throw e;
            }
        }
        return Result.error(ResultCode.USER_UPDATE_PHONE_NOT_EXIST, student);
    }

    @Override
    @Transactional
    public Student UpdateUrl(Integer id, String url) throws Error{
        ServiceUtilities.InitializeObject(student);
        try {
            student = studentAppDataObj.FetchStudentObjectById(id);
        }catch (Error e){
            throw e;
        }
        student.setUrl(url);
        return student;
    }

    @Override
    @Transactional
    public Result GetAllInfo() {
        listStudent.clear();
        try {
            listStudent = studentAppDataObj.FetchStudentObject();
        } catch (Error e) {
            throw e;
        }
        return Result.success(ResultCode.SUCCESS, listStudent);
    }

    @Override
    @Transactional
    public Result GetStuInfoById(Integer id){
        ServiceUtilities.InitializeObject(student);
        try{
            student = studentAppDataObj.FetchStudentObjectById(id);
        }catch (Error e){
            throw e;
        }
        return Result.success(ResultCode.SUCCESS,student);
    }

}

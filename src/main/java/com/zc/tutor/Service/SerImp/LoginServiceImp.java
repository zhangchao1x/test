package com.zc.tutor.Service.SerImp;

import com.zc.tutor.Common.Result.Result;
import com.zc.tutor.Common.Result.ResultCode;
import com.zc.tutor.Entity.Student;
import com.zc.tutor.Entity.Teacher;
import com.zc.tutor.Repository.StudentRep;
import com.zc.tutor.Service.LoginService;
import com.zc.tutor.Util.ServiceUtilities;
import com.zc.tutor.Util.StudentAppDataObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImp implements LoginService {

    StudentAppDataObj studentAppDataObj;
    @Autowired
    private StudentRep studentRep;

    @Override
    @Transactional
    public Result register(Student student){
        if (ServiceUtilities.isMobileNO(student.getPhone())) {
            if (student.getPassword().length() > 16) {
                return Result.error(ResultCode.USER_PASSWORD_STARDAR_ERROR, student);
            }
            if (studentRep.findByPhone(student.getPhone())!=null) {
                return Result.error(ResultCode.USER_PHONE_EXIST, student);
            }
            return Result.success(ResultCode.SUCCESS, studentRep.save(student));
        }
        return Result.error(ResultCode.USER_REGISTER_NOT_STARDAR,student);
    }

    @Override
    @Transactional
    public Result login(String phone,String password) throws Error{
        try {
            Student student = studentAppDataObj.FetchStudentByPhone(phone);
            if(student.getStuId() != null && student.getPassword().equals(password)) {
                return Result.success(ResultCode.SUCCESS);
            }else{
                return Result.error(ResultCode.USER_LOGIN_ERROR);
            }
        }catch(Error e){
            throw e;
        }
    }

}

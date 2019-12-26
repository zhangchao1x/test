package com.zc.tutor.Service.SerImp;

import com.zc.tutor.Common.Result.Result;
import com.zc.tutor.Common.Result.ResultCode;
import com.zc.tutor.Entity.Student;
import com.zc.tutor.Entity.Teacher;
import com.zc.tutor.Repository.TeacherRep;
import com.zc.tutor.Service.TeacherService;
import com.zc.tutor.Util.ServiceUtilities;
import com.zc.tutor.Util.StudentAppDataObj;
import com.zc.tutor.Util.TeacherAppDataObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherSerImp implements TeacherService {


    private TeacherAppDataObj teacherAppDataObj;
    @Autowired
    private TeacherRep teacherRep;

    List<Teacher> listTeacher = new ArrayList<>();
    Teacher teacher = new Teacher();

    @Override
    @Transactional
    public Result UpdateInfo(Teacher teacher) {
        ServiceUtilities.InitializeObject(teacher);
        if (teacherAppDataObj.FetchTeacherObjectByPhone(teacher.getTid(), teacher.getPhone()).getTid() != null) {
            return Result.error(ResultCode.USER_UPDATE_PHONE_EXIST,teacher);
        }
        if (ServiceUtilities.isMobileNO(teacher.getPhone())) {
            try {
                return Result.success(ResultCode.SUCCESS, teacher);
            } catch (Error e) {
                throw e;
            }
        }
        return Result.error(ResultCode.USER_UPDATE_PHONE_NOT_EXIST, teacher);
    }

    @Override
    @Transactional
    public Result GetAllInfo() {
        listTeacher.clear();
        try {
            listTeacher = teacherAppDataObj.FetchTeacherObject();
        } catch (Error e) {
            throw e;
        }
        return Result.success(ResultCode.SUCCESS, listTeacher);
    }

    @Override
    @Transactional
    public Result GetTeaInfoById(Integer id) {
        ServiceUtilities.InitializeObject(teacher);
        try{
            teacher = teacherAppDataObj.FetchTeacherObjectById(id);
        }catch (Error e){
            throw e;
        }
        return Result.success(ResultCode.SUCCESS,teacher);
    }

    @Override
    @Transactional
    public Result DeleteTeaInfo(Integer id) {
        ServiceUtilities.InitializeObject(teacher);
        if (teacherRep.deleteTeacherByTid(id)) {
            return Result.success(ResultCode.SUCCESS);
        } else {
            return Result.error(ResultCode.DELETE_TEACHER_FAILED);
        }
    }

    @Override
    @Transactional
    public Result SaveTeaInfo(Teacher teacher) {
        ServiceUtilities.InitializeObject(teacher);
        teacherRep.save(teacher);
        if (teacherAppDataObj.FetchTeacherObjectById(teacher.getTid()) != null) {
            return Result.success(ResultCode.SUCCESS);
        } else {
            return Result.error(ResultCode.USER_SAVE_FAILED);
        }
    }

}

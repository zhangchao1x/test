package com.zc.tutor.Util;

import com.zc.tutor.Common.Result.ResultCode;
import com.zc.tutor.Entity.Teacher;
import com.zc.tutor.Repository.TeacherRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.zc.tutor.Util
 * @ClassName TeacherAppDataObj
 * @Author Lucas
 * @Date 10/10/2019 8:43 PM
 **/
public class TeacherAppDataObj {

    @Autowired
    TeacherRep teacherRep;

    Teacher teacher = new Teacher();
    List<Teacher> listTeacher = new ArrayList<>();

    public boolean IsFetchTeacher(Integer id){
        ServiceUtilities.InitializeObject(teacher);
        teacher = teacherRep.findByTid(id);
        if (teacher.getTid() != null) return true;
        else return false;
    }
        public Teacher FetchTeacherObjectById(Integer id){
        ServiceUtilities.InitializeObject(teacher);
        teacher = teacherRep.findByTid(id);
        if (teacher.getTid() != null){
            return teacher;
        }else{
            throw new Error(ResultCode.FIND_STUDENT_FAILED.getMsg());
        }
    }

    public Teacher FetchTeacherObjectByPhone(Integer id, String phone){
        ServiceUtilities.InitializeObject(teacher);
        teacher= teacherRep.findByPhoneAndTid(id, phone);
        if(teacher.getTid() != null) {
            return teacher;
        }else{
            throw new Error(ResultCode.FIND_STUDENT_FAILED.getMsg());
        }
    }

    public List<Teacher> FetchTeacherObject(){
        listTeacher.clear();
        listTeacher = teacherRep.findAll();
        if(listTeacher.isEmpty() != true) {
            return listTeacher;
        }else{
            throw new Error(ResultCode.FIND_STUDENT_FAILED.getMsg());
        }
    }

    public boolean SaveTeacher(Teacher teacher) {
        teacherRep.save(teacher);
        if (IsFetchTeacher(teacher.getTid())){
            return true;
        }else{
            throw new Error(ResultCode.USER_SAVE_FAILED.getMsg());
        }
    }
}

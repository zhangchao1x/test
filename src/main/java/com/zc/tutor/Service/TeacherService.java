package com.zc.tutor.Service;

import com.zc.tutor.Common.Result.Result;
import com.zc.tutor.Entity.Student;
import com.zc.tutor.Entity.Teacher;

import java.util.List;

public interface TeacherService {

     Result UpdateInfo(Teacher teacher);
     Result GetAllInfo();
     Result GetTeaInfoById(Integer id);
     Result DeleteTeaInfo(Integer id);
     Result SaveTeaInfo(Teacher teacher);
}

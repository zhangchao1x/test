package com.zc.tutor.Service;

import com.zc.tutor.Common.Result.Result;
import com.zc.tutor.Common.Result.ResultCode;
import com.zc.tutor.Entity.Student;

import javax.validation.Valid;

/*
  * @Author Lucas
  * @Description UserServiceApi
  * @Date 8:48 PM 9/20/2019
  * @Param
  * @return
**/
public interface UserService {

     Result UpdateInfo(Student student);
     Result GetAllInfo();
     Result GetStuInfoById(Integer id);
     Student UpdateUrl(Integer id,String url);
}

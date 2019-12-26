package com.zc.tutor.Service;

import com.zc.tutor.Common.Result.Result;
import com.zc.tutor.Entity.Student;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;


public interface  LoginService {
     Result register(Student student);
     Result login(String phone,String password);
}

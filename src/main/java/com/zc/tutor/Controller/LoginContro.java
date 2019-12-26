package com.zc.tutor.Controller;

import com.zc.tutor.Common.Result.Result;
import com.zc.tutor.Common.Result.ResultCode;
import com.zc.tutor.Entity.Student;
import com.zc.tutor.Repository.StudentRep;
import com.zc.tutor.Service.LoginService;
import com.zc.tutor.Util.ServiceUtilities;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class LoginContro {

    @Autowired
    private LoginService loginservice;

    Result result = new Result();

    @ResponseBody
    @PostMapping (value="/auth/register")
    @ApiOperation(value="注册")
    public Result register(@Valid @RequestBody Student student) {
        ServiceUtilities.InitializeObject(result);
        try {
            result = loginservice.register(student);
        }catch (Error e){
            result.setMsg(e.toString());
            result.setCode(401);
        }
        return result;
    }


    @PostMapping (value="/auth/login")
    @ApiOperation(value="登录")
    public Result login(@RequestParam(value = "phone",required = true) String phone,
                        @RequestParam(value = "password",required = true) String password) {
        ServiceUtilities.InitializeObject(result);
        try {
            result = loginservice.login(phone,password);
        }catch (Error e){
            result.setMsg(e.toString());
            result.setCode(401);
        }
        return result;
    }

}

package com.zc.tutor.Controller;

import com.zc.tutor.Common.Result.Result;
import com.zc.tutor.Common.Result.ResultCode;
import com.zc.tutor.Entity.Student;
import com.zc.tutor.Repository.StudentRep;
import com.zc.tutor.Service.UserService;
import com.zc.tutor.Util.ServiceUtilities;
import com.zc.tutor.Util.StudentAppDataObj;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserContro {

    @Autowired
    UserService userService;

    Result result = new Result();

    @PutMapping(value = "/auth/update")
    @ApiOperation(value="更新用户信息")
    public Result UpdateInfo(@Valid @RequestBody Student student) {
        ServiceUtilities.InitializeObject(result);
        result = userService.UpdateInfo(student);
        return result;
    }

    @RequestMapping(value ="/auth/getInfo", method= RequestMethod.GET)
    @ApiOperation(value="获取单个用户信息")
    public Result GetInfo(@RequestParam(value = "stuId", required = true) Integer stuId) {
        ServiceUtilities.InitializeObject(result);
        result = userService.GetStuInfoById(stuId);
        return result;
    }

    @ResponseBody
    @RequestMapping(value ="/auth/getAllInfo", method= RequestMethod.GET)
    @ApiOperation(value="获取所有信息")
    public Result GetAllInfo(){
        ServiceUtilities.InitializeObject(result);
        result = userService.GetAllInfo();
        return result;
    }

}

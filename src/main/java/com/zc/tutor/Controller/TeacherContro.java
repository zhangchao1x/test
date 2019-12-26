package com.zc.tutor.Controller;

import com.zc.tutor.Common.Result.Result;
import com.zc.tutor.Entity.Teacher;
import com.zc.tutor.Service.TeacherService;
import com.zc.tutor.Util.ServiceUtilities;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherContro {

    @Autowired
    private TeacherService teacherService;

    Result result = new Result();


    @PutMapping(value = "/teacher/update")
    @ApiOperation(value="更新教师信息")
    public Result teacherUpdateInfo(@RequestBody Teacher teacher){
        ServiceUtilities.InitializeObject(result);
        result = teacherService.UpdateInfo(teacher);
        return result;
    }

    @GetMapping(value = "/teacher/getInfo")
    @ApiOperation(value="查看教师信息")
    public Result teacherInfoGet(@RequestParam(value = "Teaid", required = true) Integer teaid){
        ServiceUtilities.InitializeObject(result);
        result = teacherService.GetTeaInfoById(teaid);
        return result;
    }

    @DeleteMapping(value = "/teacher/del")
    @ApiOperation(value="删除教师信息")
    public Result teacherDel(@RequestParam(value = "Teaid", required = true) Integer teaid){
        ServiceUtilities.InitializeObject(result);
        result = teacherService.DeleteTeaInfo(teaid);
        return result;
    }

      @PostMapping(value = "/teacher/add")
      @ApiOperation(value="增加教师")
      public Result teacherAdd(@RequestBody Teacher teacher){
          ServiceUtilities.InitializeObject(result);
          result = teacherService.SaveTeaInfo(teacher);
          return result;
      }

}

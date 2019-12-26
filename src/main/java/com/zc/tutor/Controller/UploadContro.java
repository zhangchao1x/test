package com.zc.tutor.Controller;


import com.zc.tutor.Common.Result.Result;
import com.zc.tutor.Common.Result.ResultCode;
import com.zc.tutor.Entity.Student;
import com.zc.tutor.Repository.StudentRep;
import com.zc.tutor.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

@RestController
public class UploadContro {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/upload")
    @ResponseBody
    public Result uploadPic(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
                            @RequestParam(value = "id",required = true) Integer id) throws IOException {
        //目前这里是写死的本地硬盘路径
        String path = "C:\\tutor\\src\\main\\resources\\Statics\\Viedo";
        //获取文件名称
        String fileName = file.getOriginalFilename();
        //获取文件名后缀
        Calendar currTime = Calendar.getInstance();
        String time = String.valueOf(currTime.get(Calendar.YEAR)) + String.valueOf((currTime.get(Calendar.MONTH) + 1));
        //获取文件名后缀
        String suffix = fileName.substring(file.getOriginalFilename().lastIndexOf("."));
        suffix = suffix.toLowerCase();
        if (suffix.equals(".jpg") || suffix.equals(".jpeg") || suffix.equals(".png")/* || suffix.equals(".gif")*/) {
            fileName = UUID.randomUUID().toString() + suffix;
            File targetFile = new File(path, fileName);
            if (!targetFile.getParentFile().exists()) {    //注意，判断父级路径是否存在
                targetFile.getParentFile().mkdirs();
            }
            long size = 0;
            //保存
            try {
                file.transferTo(targetFile);
                size = file.getSize();
            } catch (Exception e) {
                e.printStackTrace();
                return Result.error(ResultCode.UPLOAD_FAIL);
            }
            //项目url，这里可以使用常量或者去数据字典获取相应的url前缀；
            String fileUrl = "http://localhost:8080";
            //文件获取路径
            fileUrl = fileUrl + request.getContextPath() + "/img/" + fileName;
            return Result.success(ResultCode.SUCCESS, userService.UpdateUrl(id,fileUrl));
        } else {
            return Result.error(ResultCode.UPLOAD_FAIL);
        }
    }

}

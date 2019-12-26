package com.zc.tutor.Util;

import com.zc.tutor.Entity.Student;
import com.zc.tutor.Entity.Teacher;
import com.zc.tutor.Repository.StudentRep;
import com.zc.tutor.Repository.TeacherRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Package com.zc.tutor.Util
 * @ClassName ServiceUtilities
 * @Author Lucas
 * @Date 9/20/2019 7:01 PM
 **/
public class ServiceUtilities {


    public static boolean isMobileNO(String mobile){
        if (mobile.length() != 11){
            return false;
        }else{
            String part = "^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|" +
                          "(1705)\\d{7}|((13[0-2])|(145)|(15[5-6])|(176)|(18[5,6]))\\d{8}|(1709)\\d{7}" +
                          "|((133)|(153)|(177)|(18[0,1,9])|(149))\\d{8}|((170))\\d{8}|(1718)|(1719)\\d{7}$";
            Pattern pattern1 = Pattern.compile(part);
            Matcher match1 = pattern1.matcher(mobile);
            boolean isMatch1 = match1.matches();
            if(isMatch1){
                return true;
            }else return false;
        }
    }

    public static boolean isNullOrEmpty(Object object){
        return  false;
    }

//    public Teacher FetchTeacherObjectByPhone(String id, String phone){
//        teacher = teacherRep.findByPhoneAAndId(id, phone);
//        return  teacher;
//    }
    /*
      * @Author Lucas
      * @Description Make Object empty or null
      * @Date 7:51 PM 9/20/2019
      * @Param [obj]
      * @return java.lang.Object
    **/
    public static Object InitializeObject(Object obj){
        obj = new Object();
        obj = null;
        return  obj;
    }

}

package com.example.adminteacher.controller;


import com.example.adminteacher.service.UserService;
import com.example.common.pojo.Teacher;
import com.example.common.unit.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param
     * @return
     */
    public static String MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        }catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public ResponseResult login(@RequestBody Teacher teacher){
        System.out.println(teacher+"teacher");
        Teacher teacher1=userService.login(teacher.getTno(),teacher.getPassword(),teacher.getType());
        System.out.println(teacher1);
        if (teacher1 == null){
            return  ResponseResult.build(500,"登陆失败");
        }else{
            return  ResponseResult.build(200,"登陆成功",teacher1);
        }
    }
}

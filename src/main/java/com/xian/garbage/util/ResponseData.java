package com.xian.garbage.util;

import org.springframework.stereotype.Component;

@Component
public class ResponseData {

    //成功
    public static final String STATUS_SUCCESS = "SUCCESS";
    //失败
    public static final String STATUS_FAIL = "FAIL";
    //管理员
    public static final String STATUS_ADMIN = "ADMIN";
    //卫生员
    public static final String STATUS_TEACHER = "HYGIENIST";
    //两次密码不一致
    public static final String STATUS_ATYPISM = "ATYPISM";
    //旧密码错误
    public static final String STATUS_OLDPWD = "OLDPWD";
    //已存在
    public static final String STATUS_EXIST = "EXIST";

}

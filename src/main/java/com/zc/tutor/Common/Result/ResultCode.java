package com.zc.tutor.Common.Result;

public enum ResultCode {

    SUCCESS(100,"操作成功"),
    USER_LOGIN_ERROR(201,"登录失败，用户名或密码错误"),
    UPLOAD_FAIL(203,"上传失败"),
    USER_PHONE_EXIST(204,"注册失败，该手机号已经被注册"),
    USER_PASSWORD_STARDAR_ERROR(205,"注册失败，密码必须小于16位"),
    USER_REGISTER_NOT_STARDAR(206,"注册失败，手机号不存在"),
    USER_UPDATE_PASSWODR_FAIL(208,"密码不符合规范"),
    USER_UPDATE_PHONE_NOT_EXIST(209,"手机号不存在"),
    USER_UPDATE_PHONE_EXIST(210,"手机号已经注册"),
    USER_SAVE_FAILED(211,"保存失败"),
    FIND_STUDENT_FAILED(212,"查询失败"),
    DELETE_TEACHER_FAILED(213,"删除失败");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }
}

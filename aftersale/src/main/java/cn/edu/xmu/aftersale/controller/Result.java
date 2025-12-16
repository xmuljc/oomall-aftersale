package cn.edu.xmu.aftersale.controller;

import lombok.Data;

@Data
public class Result {
    private int errno;
    private String errmsg;
    private Object data;

    public static Result success() {
        Result r = new Result();
        r.errno = 0;
        r.errmsg = "成功";
        return r;
    }

    public static Result fail(int code, String msg) {
        Result r = new Result();
        r.errno = code;
        r.errmsg = msg;
        return r;
    }
}
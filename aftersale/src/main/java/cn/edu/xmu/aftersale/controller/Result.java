package cn.edu.xmu.aftersale.controller;

import java.util.Map;

public final class Result {
    private Result() {}
    public static Map<String, Object> ok() {
        return Map.of("errno", 0, "errmsg", "成功");
    }
    public static Map<String, Object> fail(int errno, String errmsg) {
        return Map.of("errno", errno, "errmsg", errmsg);
    }
}

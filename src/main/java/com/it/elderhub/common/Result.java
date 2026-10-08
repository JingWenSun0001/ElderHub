package com.it.elderhub.common;

import lombok.Data;

@Data
public class Result<T> {
    private int code; // 200: 成功, 500: 失败
    private String msg;
    private T data;

    public static <T> Result<T> success() {
        return buildResult(200, "操作成功", null);
    }

    public static <T> Result<T> success(T data) {
        return buildResult(200, "操作成功", data);
    }

    public static <T> Result<T> error(String msg) {
        return buildResult(500, msg, null);
    }

    private static <T> Result<T> buildResult(int code, String msg, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
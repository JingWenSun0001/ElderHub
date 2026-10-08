package com.it.elderhub.dto;

import com.it.elderhub.dto.LoginUser;

/**
 * ThreadLocal 保证每个现成有自己独立的数据 不会把用户A的信息串到用户B的请求里
 */

public class UserContext {

    private static final ThreadLocal<LoginUser> holder = new ThreadLocal<>();

    public static void set(LoginUser loginUser) {
        holder.set(loginUser);
    }

    public static LoginUser get() {
        return holder.get();
    }

    public static void clear() {
        holder.remove();
    }
}
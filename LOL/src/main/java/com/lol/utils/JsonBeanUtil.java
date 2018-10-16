package com.lol.utils;

import com.lol.domain.JsonBean;

public class JsonBeanUtil {
    public static JsonBean w(int code,Object msg) {
        JsonBean bean = new JsonBean();
        bean.setCode(code);
        bean.setMsg(msg);
        return bean;
    }
}

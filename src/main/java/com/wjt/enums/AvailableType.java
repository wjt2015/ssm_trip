package com.wjt.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @Time 2020/4/24/20:57
 * @Author jintao.wang
 * @Description
 */
public enum AvailableType {
    AVAILABLE((byte) 1, "可用"),
    NOT_AVAILABLE((byte)2,"不可用");


    public final byte code;
    public final String desc;

    AvailableType(byte code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static final Map<Byte, AvailableType> map = new HashMap<>();

    static {
        for (AvailableType availableType : values()) {
            map.put(availableType.code, availableType);
        }
    }


    public static AvailableType codeOf(byte code) {
        return map.get(code);
    }


}

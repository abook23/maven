package com.demo.util;

import java.util.UUID;

public class IdUtils {

	 /**
     * 产生一个36个字符的UUID
     *
     * @return UUID
     */
    public static String getId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}

package org.magisoul.util;

import java.util.UUID;

public class UUIDUtil {

    /**
     * 获取32位的UUID
     * @return String
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 获取32位小写的UUID
     * @return String
     */
    public static String createUUID() {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}

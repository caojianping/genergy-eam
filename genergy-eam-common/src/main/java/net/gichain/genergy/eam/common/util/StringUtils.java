package net.gichain.genergy.eam.common.util;

import java.util.Arrays;

public class StringUtils {
    public static final String empty = "";

    public static boolean isNull(String value) {
        return value == null;
    }

    public static boolean isEmpty(String value) {
        if (value == null) return true;
        return value.length() == 0;
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.length() == 0;
    }

    public static String[] separate(String str, String separator) {
        if (StringUtils.isNullOrEmpty(str)) {
            return new String[]{};
        }
        return str.split(separator);
    }
}
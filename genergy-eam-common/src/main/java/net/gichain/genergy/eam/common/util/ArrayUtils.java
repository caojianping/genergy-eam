package net.gichain.genergy.eam.common.util;

public class ArrayUtils {
    public static String findItem(String[] arrs, String prefix) {
        String result = "";
        for (String item : arrs) {
            if (item.startsWith(prefix)) {
                result = item;
                break;
            }
        }
        return result;
    }
}

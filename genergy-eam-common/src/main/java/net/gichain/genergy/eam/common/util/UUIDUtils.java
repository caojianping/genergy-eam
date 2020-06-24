package net.gichain.genergy.eam.common.util;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

public class UUIDUtils {
    public static String randomUUID() {
        UUID uuid = UUID.randomUUID();
        String suuid = uuid.toString();
        return suuid.replace("-", "");
    }

    public static String randomWords(int length, boolean onlyDigit) {
        char[] chars = (onlyDigit ? "123456789" : "0123456789abcdefghijklmnopqrwtuvzxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
        int count = onlyDigit ? 9 : 62;

        char[] result = new char[length];
        Random random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int n = random.nextInt(count);
            result[i] = chars[n];
        }
        return new String(result);
    }
}

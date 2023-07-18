package net.gichain.genergy.eam.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class PasswordUtils {
    private static final String hexDigits[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    // 针对单个byte，256的byte通过16拆分为d1和d2
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    // 遍历8个byte，转化为16位进制的字符，即0-F
    private static String byteArrayToHexString(byte b[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            sb.append(byteToHexString(b[i]));
        }
        return sb.toString();
    }

    // 创建盐
    public static String createSalt(int length) {
        char[] chars = "0123456789abcdefghijklmnopqrwtuvzxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] salts = new char[length];
        Random random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int n = random.nextInt(62);
            salts[i] = chars[n];
        }
        return new String(salts);
    }

    // MD5加密
    public static String MD5Encrypt(String text) {
        if (StringUtils.isNullOrEmpty(text)) return null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return byteArrayToHexString(md.digest(text.getBytes()));
        } catch (NoSuchAlgorithmException exp) {
            exp.printStackTrace();
        }
        return null;
    }
}

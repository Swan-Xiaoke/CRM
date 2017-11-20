package com.swan.utils.secret;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by dllo on 17/11/10.
 */
public class MD5Util {
    public static String md5(String str) {
        StringBuffer md5Code = new StringBuffer();
        try {
            /**
             * 将字符串转化为字节数组,
             * 字符串中每个字符转化为对应的ASCII值作为字节数组中的元素
             * 将字节数组通过固定算法转换16个元素的符号哈希值字节数组
             */
            MessageDigest instance = MessageDigest.getInstance("md5");
            byte[] digest = instance.digest(str.getBytes());

            for (byte b : digest) {
                //将哈希字节数组的每个元素通过0xff与运算转换为两个无符号的16进制字符串
                String hexString = Integer.toHexString(b & 0xff);
                if (hexString.length() < 2) {
                    //不足两位的无符号16进制字符串前面加"0"
                    hexString = "0" + hexString;
                }

                //通过StringBuffer的append方法将16个长度为2的无符号进制字符串拼接成一个32位的String类型字符串
                md5Code = md5Code.append(hexString);
            }

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5Code.toString();
    }
}

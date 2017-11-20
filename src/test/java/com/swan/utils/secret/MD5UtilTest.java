package com.swan.utils.secret;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/10.
 */
public class MD5UtilTest {
    @Test
    public void test(){
        String str = "MD5加密";
        str = MD5Util.md5(str);
        System.out.println(str);
    }

}
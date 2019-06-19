package com.happy.hhome.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @author haopeng17313
 */
public class MD5Utils {
    public String encrypt(String password) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        Integer hashIterations = 2;
        String algorithmName = "md5";
        String result = new SimpleHash(algorithmName, password, salt, hashIterations).toHex();
        return result;
    }
}

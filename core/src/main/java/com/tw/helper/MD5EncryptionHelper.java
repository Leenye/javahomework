package com.tw.helper;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by twer on 7/14/15.
 */
public class MD5EncryptionHelper {
    public static String stringMD5(String password){
        String stringMD5 = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//            byte[] inputBytes = password.getBytes();

            messageDigest.update(password.getBytes(),0,password.length());
            stringMD5 = new BigInteger(1,messageDigest.digest()).toString(16);

//            messageDigest.update(password.getBytes());
//
//            messageDigest.update(password.getBytes());
//            stringMD5 = messageDigest.digest().toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringMD5;
    }
}

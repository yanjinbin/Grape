package com.yanjinbin.frastructue;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * 加密
 * Created by Silver & Bullet
 * since 2016-十二月
 */
@Slf4j
public final class EncryptUtil {

    /**
     * @param descript content  to be encrypted
     * @return encrypt content if exist SHA-1 algorithm,else return blank string  if not exist
     */
    public static String SHA1(String descript) {
        try {
            //h获得SHA-1摘要
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            //使用指定的字节更新摘要
            messageDigest.update(descript.getBytes());
            //获得密文
            byte[] digest = messageDigest.digest();
            //将密文转换成hex字符串形式
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                String shaHex = Integer.toHexString(digest[i] & 0xff);
                if (shaHex.length() < 2) {//askme
                    sb.append(0);
                }
                sb.append(shaHex);
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(),e.getClass().getName());
            throw  new RuntimeException(e.getMessage(),e);
        }

    }

    public static String MD5(String descript) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(descript.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                String shaHex = Integer.toHexString(digest[i] & 0xff);
                if (shaHex.length() < 2) {//askme
                    sb.append(0);
                }
                sb.append(shaHex);
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(),e.getClass().getName());
            throw  new RuntimeException(e.getMessage(),e);
        }

    }


    public static byte[] encryptAES(String content ,String password){
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128,new SecureRandom(password.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] encoded = secretKey.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(encoded, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            byte[] bytesContent = content.getBytes("utf-8");
            return bytesContent;
        } catch (Exception e) {
            log.error(e.getMessage(),e.getClass().getName());
            throw  new RuntimeException(e.getMessage(),e);
        }
    }

    public static byte[] decryptAES(byte[] content,String password){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128,new SecureRandom(password.getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] encoded = secretKey.getEncoded();
            new SecretKeySpec(encoded,"AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            byte[] result = cipher.doFinal(content);
            return result;
        }catch (Exception e){
            log.error(e.getMessage(),e.getClass().getName());
            throw  new RuntimeException(e.getMessage(),e);
        }

    }
}

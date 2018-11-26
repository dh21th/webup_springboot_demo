package com.webup.soa.gateway.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/******************************************
 * @createDate: 2018/2/26
 * @company: (C) Copyright 亿兆华盛 2018
 * @since: JDK 1.8
 * @projectName:webup-gateway
 * @Description:
 ******************************************/
public class AesEncryptionUtil {

    public static IvParameterSpec iv =  new IvParameterSpec("0102030405060708".getBytes());

    public static final String AES_CBC_PKCS5 = "AES/CBC/PKCS5Padding";

    /**
     * 加密
     * @param source
     * @param cipherType
     * @param key
     * @return
     * @throws Exception
     */
    public static String encrypt(String source,String cipherType,String key) throws Exception {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        if (key == null) {
            System.out.print("Key为空null");
            return null;
        }
//        判断Key是否为16位
        if (key.length() != 16) {
            System.out.print("Key长度不是16位");
            return null;
        }
        byte[] raw = key.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance(cipherType);
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(source.getBytes());

        return base64Encoder.encode(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    /**
     * 解密
     * @param source
     * @param cipherType
     * @param key
     * @return
     * @throws Exception
     */
    public static String decrypt(String source,String cipherType, String key) throws Exception {
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            // 判断Key是否正确
            if (key == null) {
                System.out.print("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (key.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            }
            byte[] raw = key.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance(cipherType);

            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = base64Decoder.decodeBuffer(source);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                return  new String(original);
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }


}

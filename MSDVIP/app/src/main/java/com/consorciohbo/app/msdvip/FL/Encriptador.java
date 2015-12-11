package com.consorciohbo.app.msdvip.FL;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Diego on 18/11/15.
 */
public class Encriptador {
    private static String algorithm;
    private static byte[] keyValue;
    private static byte[] ivValue;

    private static SecretKey key;
    private static IvParameterSpec iv;

    public Encriptador(){
        algorithm = "AES/CBC/PKCS5Padding";
        keyValue= "0000020509463124".getBytes();
        ivValue= "0000020509463124".getBytes();
        key = new SecretKeySpec(keyValue, 0, keyValue.length, "AES");
        iv = new IvParameterSpec(ivValue);
    }

    // Performs Encryption
    public String encrypt(String plainText) throws Exception
    {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] encVal = cipher.doFinal(plainText.getBytes());
        String encryptedValue = Base64.encodeToString(encVal, Base64.DEFAULT);
        return encryptedValue.substring(0,encryptedValue.length()-1);
    }

    // Performs decryption
    public String decrypt(String encryptedText) throws Exception
    {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] decodedValue = Base64.decode(encryptedText,Base64.DEFAULT);
        byte[] decValue = cipher.doFinal(decodedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
}

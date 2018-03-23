package com.co.procomercio.utilities;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;


public class DesEncrypter {
    
    static Cipher ecipher;
    static Cipher dcipher;
    
    private static final String ENCRIPT_KEY = "38GfvCsdfy";

    public DesEncrypter() {
        SecretKeyFactory keyfactory;
        Key key = new SecretKeySpec("MyEncriptionKey".getBytes(),"DES/CBC/PKCS5Padding");
         try 
         {
            byte[] rawkey = ENCRIPT_KEY.getBytes();
            // Convert the raw bytes to a secret key like this
            DESKeySpec keyspec = new DESKeySpec(rawkey);
            keyfactory = SecretKeyFactory.getInstance("DES");
            key = keyfactory.generateSecret(keyspec);
            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);
    } catch (Exception e) {
        System.out.println("Error en DesEncrypter. "+e);
        }
    }
	
    public String encrypt(String str) {
        try {            
            // Encode the string into bytes using utf-8
            byte[] utf8 = str.getBytes("UTF8");
            // Encrypt
            byte[] enc = ecipher.doFinal(utf8);
            // Encode bytes to base64 to get a string
            return new Base64Encoder().encode(enc);
        } catch (Exception e) {
            System.out.println("Error en DesEncrypter al encriptar. "+e);
        }
        return null;
    }

    public String decrypt(String str) {
        try {
            // Decode base64 to get bytes
            byte[] dec = new Base64Encoder().decode(str);
            // Decrypt
            byte[] utf8 = dcipher.doFinal(dec);
            // Decode using utf-8
            return new String(utf8, "UTF8");
        } catch (Exception e) {
            System.out.println("Error en DesEncrypter al desencriptar. "+e);
        }
        return null;
    }
    
}

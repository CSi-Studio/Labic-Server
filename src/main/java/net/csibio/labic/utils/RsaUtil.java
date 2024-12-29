package net.csibio.labic.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class RsaUtil {

    public final static String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEA0+BvYwZZV55KgIZo\n" +
            "2PDden/3X/SeQiFf4t3oIF4XobUCxVaL1gR6jPio0yybqw/71wdXmZYWNXzwKlxq\n" +
            "FRE4ewIDAQABAkEAzfAT1BhTtoowuAPs3RAg9fRzqVzGhliSLpyqBuvt5EmbVvKL\n" +
            "eTeRkxpKAYgSjb37FA1mdzqAHS7/3HNOom7UQQIhAPAsiN3EsL/E9XGyoKIUrtku\n" +
            "/mGknmBKIbsnM1dOQnBpAiEA4daOr958DSw+MPywvStASkYiWYZt+smV5NzjbCol\n" +
            "xUMCIQCF95FwgmJE1cxC22yWfAr7wibKuFRPSYp/JmKQ9GpC4QIgCaGn5jI74ifv\n" +
            "4xDzzK2KiWBiWKUWDasJPIB7JoLJp5cCICVdbNgW5PWJWE5rXYKOT8prQjKiyMmy\n" +
            "4jWrJgemAgsI";

    /**
     * RSA私钥解密
     *
     * @param str
     *            加密字符串
     * @param key
     *            私钥
     * @return 铭文
     * @throws Exception
     *             解密过程中的异常信息
     */
     public static String decrypt(String str, String key) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

}

package org.magisoul.util.security;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

    /**
     * 使用md5的算法进行加密
     */
    public static String md5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有md5这个算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);// 16进制数字
        // 如果生成数字未满32位，需要前面补0
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    private static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static MessageDigest messagedigest = null;

    /**
     * MessageDigest初始化
     */
    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.err.println("MD5FileUtil messagedigest初始化失败");
            e.printStackTrace();
        }
    }


    /**
     * 生成文件的特征值
     */
    public static String genFileFeature(byte[] fileBytes,String salt) {
        byte[] saltByte=salt.getBytes();
        System.arraycopy(fileBytes, 0, saltByte, 0, saltByte.length);
        messagedigest.update(saltByte);
        messagedigest.update(fileBytes);
        return bufferToHex(messagedigest.digest());
    }

    public static String genFileFeatureByUrl(String url,String salt) {
        byte[] fileByte= new byte[0];
        try{
            fileByte = urlTobyte(url);
        }catch(IOException e){
            e.printStackTrace();
        }

        return Md5Util.genFileFeature(fileByte,salt);

    }

    public static byte[] urlTobyte(String url) throws IOException{
        byte[] content=null;
        URL ur = new URL(url);
        BufferedInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new BufferedInputStream(ur.openStream());
            out = new ByteArrayOutputStream(1024);
            byte[] temp = new byte[1024];
            int size = 0;
            while ((size = in.read(temp)) != -1) {
                out.write(temp, 0, size);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(null!=in){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(null!=out)
            content= out.toByteArray();
        return content;
    }

    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuilder stringbuffer = new StringBuilder(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            char c0 = hexDigits[(bytes[l] & 0xf0) >> 4];
            char c1 = hexDigits[bytes[l] & 0xf];
            stringbuffer.append(c0);
            stringbuffer.append(c1);
        }
        return stringbuffer.toString();
    }

}

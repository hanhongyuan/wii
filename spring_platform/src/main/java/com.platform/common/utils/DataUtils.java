package com.platform.common.utils;

import org.apache.commons.codec.binary.Hex;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import static java.security.SecureRandom.*;

/**
 * Created by tanghong on 2017/3/8.
 */
public class DataUtils {

    private static SecureRandom srandom() throws Exception{
        return getInstance("SHA1PRNG"); //new SecureRandom()
    }

    private static class Magics{
        // 62进制对应关系，禁止修改该值 (TODO: 从配置文件获取, 但要保证第一个数字为 E)
        private final static String al = "EeXsx84n9NjyTYtJuUfFAa5mMIivG61VqQLbgBlPp02CHcWh7rKwR3kODZozSd";
        //private final static String nums = "0123456789";
        private final static int base = al.length();

        private static Map<Integer, Character> char2num(){
            Map<Integer, Character> map = new HashMap<>();
            char[] ch = al.toCharArray();
            for (int i=0; i<ch.length; i++){
                map.put(al.indexOf(i), ch[i]);
            }
            return map;
        }
    }

    public static String genString(int size)
    throws Exception{
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<size; i++){
            sb.append(Magics.char2num().get(srandom().nextInt(Magics.base)));
        }
        return sb.toString();
    }


    public static byte[] getBytes(String str) throws UnsupportedEncodingException{
        return str.getBytes("UTF-8");
    }

    public static byte[] sha1(byte[] bytes) throws NoSuchAlgorithmException{
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.update(bytes);
        return digest.digest();
    }

    public static String hex(byte[] bytes){
        return new String(Hex.encodeHex(bytes));
    }

    // 用 sha1 编码成 hex 格式
    public static String sha1Hex(String text)throws Exception{
        return hex(sha1(getBytes(text)));
    }
}

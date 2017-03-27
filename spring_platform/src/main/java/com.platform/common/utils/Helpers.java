package com.platform.common.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by tanghong on 2017/3/8.
 */
public class Helpers {

    public static boolean verifySignature(String timestamp, String nonce, String signature, String token)
    throws Exception{
        List<String> list = Arrays.asList(token, timestamp, nonce);
        Collections.sort(list);
        //Arrays.sort();
        StringBuffer sb = new StringBuffer();
        list.forEach(f -> sb.append(f));
        return DataUtils.sha1Hex(sb.toString()).equals(signature);
    }

    private static String addString(List<Object> list, String start, String sep, String end){
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        sb.append(start);
        for (Object x:list){
            if (first) {
                sb.append(x);
                first = false;
            }
            else {
                sb.append(sep);
                sb.append(x);
            }
        }
        sb.append(end);
        return sb.toString();
    }

    public static String mkString(List<Object> list, String seq){
        return addString(list, "", seq, "");
    }
}

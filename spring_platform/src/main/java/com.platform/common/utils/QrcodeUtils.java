package com.platform.common.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.platform.common.weixin.dto.WxFileDto;
import java.io.*;
import java.util.Hashtable;

/**
 * Created by tanghong on 2017/3/8.
 */
public class QrcodeUtils {

    private final static String fileFormat = "jpg";
    private final static int width = 450;
    private final static int height = 450;

    /**
     * 生成文件字节
     * @param url
     * @return
     * @throws Exception
     */
    public static WxFileDto genArrayByte(String url){
        String location;
        if (url.contains("http")){
            location = url;
        }
        else {
            location = "http://" + url;
        }
        Hashtable<EncodeHintType, String> hints = new Hashtable<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        byte[] bytes = null;
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(location, BarcodeFormat.QR_CODE, width, height, hints);
            ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, fileFormat, byteOs);
            bytes = byteOs.toByteArray();
            byteOs.close();
            return new WxFileDto(bytes, DataUtils.genString(8) + "." + fileFormat);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成文件
     * @param url
     * @param fileName
     * @throws Exception
     */
    public static void genFile(String url, String fileName)
    throws Exception{
        BufferedInputStream bis;
        BufferedOutputStream bos;
        Hashtable<EncodeHintType, String> hints = new Hashtable<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
            ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, fileFormat, byteOs);
            ByteArrayInputStream bs = new ByteArrayInputStream(byteOs.toByteArray());
            bis = new BufferedInputStream(bs);
            bos = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
            byte[] buff = new byte[2014];
            int begin = 0;
            int b = bis.read(buff, begin, buff.length);
            while (b != -1) {
                bos.write(buff, begin, buff.length);
                begin = begin + buff.length;
                b = bis.read(buff, begin, buff.length);
            }
            bos.flush();
            bs.close();
            bos.close();
            bis.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String genWxQrcodeHtml(String url){
        return "<h1> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 长按二维码，参与活动 </h1>" + "\n" +
        " <p> " + "\n" +
        "<img style=\"margin:0 auto;display:block;width: 50%;padding: 0px;border-color: rgb(30, 155, 232); " +
        "color: inherit;height: 100%;display: block;margin: 0 auto;\"" +
        "data-width=\"100%\" border=\"0\" vspace=\"0\" src=\""+url+"\"/>" +"\n"+
        "</p>";
    }
}

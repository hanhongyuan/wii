package com.platform.common.utils;

import com.platform.common.utils.http.HttpClientFactory;
import com.platform.common.weixin.dto.WxFileDto;
import com.sun.tools.javac.util.ByteBuffer;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tanghong on 2017/3/8.
 */
public class IOUtils {

    private final static int sizeThreshold = DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD;
    private final static int sizeMax = -1;
    private final static String encoding = "UTF-8";


    static class FileCategorys {

        private static Map<String, String> pictures = new HashMap<>();

        static {
            pictures.put("FFD8FF", "jpg");
            pictures.put("89504E47", "png");
            pictures.put("47494638", "gif");
            pictures.put("424D", "bmp");  // Windows Bitmap (bmp)
            pictures.put("89504E470D0a1a0a0000", "png");
            pictures.put("424d228c010000000000", "bmp");  // 16色位图(bmp)
            pictures.put("424d8240090000000000", "bmp");  // 24位位图(bmp)
            pictures.put("424d8e1b030000000000", "bmp");  // 256色位图(bmp)
        }
    }

    //  var fileFilter: UploadFileFilter = _

    /**
     * 获取文件后缀类型
     * @return
     */
    public static String getFileCategory(byte[] array){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<array.length; i++){
            int v = array[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        String hex = String.valueOf(stringBuilder.toString());
        return FileCategorys.pictures.getOrDefault(hex, "jpg");
    }

    /**
     * 下载流文件并获取文件名称
     * @param link
     * @return
     */
    public static WxFileDto getInputStream(String link)
    throws Exception{
        CloseableHttpResponse res = null;
        try {
            HttpGet hg = new HttpGet(link.trim());
            res = HttpClientFactory.createDefaultClient().execute(hg);
            InputStream in = res.getEntity().getContent();
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = in.read(buff, 0, 100)) > 0) {
                out.write(buff, 0, rc);
            }
            byte[] array = out.toByteArray();
            String fileName = link.substring(link.lastIndexOf("/") + 1) +"."+ getFileCategory(array);
            in.close();
            return new WxFileDto(array, fileName);
        }
        catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        finally {
            res.close();
        }
    }


}

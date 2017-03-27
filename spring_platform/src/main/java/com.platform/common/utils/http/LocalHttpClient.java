package com.platform.common.utils.http;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.platform.common.exception.WxException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by tanghong on 2017/3/6.
 */
public class LocalHttpClient {

    private final static CloseableHttpClient client = HttpClientFactory.createClient(10, 100);

    private final static Logger logger = LoggerFactory.getLogger(LocalHttpClient.class);

    public static Optional<String> handle(HttpUriRequest request){
        try {
            CloseableHttpResponse response = client.execute(request);
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                return Optional.ofNullable(content);
            }
            else {
                //client.close()
                logger.error("weixin http handle failure");
                return Optional.empty();
            }
        } catch(Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public static <T> Optional<T> handleJson(HttpUriRequest request, Class<T> c)
    throws Exception{
        String content = null;
        try {
            CloseableHttpResponse response = client.execute(request);
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                content = EntityUtils.toString(response.getEntity(), "UTF-8");
                logger.info("weixin handle return content: " + content);
                ObjectMapper om = new ObjectMapper();
                om.registerModule(new Jdk8Module());
                return Optional.ofNullable(om.readValue(content, c));
            }
            else {
                logger.info("http send msg failure");
                return Optional.empty();
            }
        }
        catch(JsonProcessingException e){
            WxException we = new WxException(content);
            we.log();
            throw we;
        }
        catch (IOException exe){
            exe.printStackTrace();
            throw exe;
        }
    }

    public static <T> Optional<T> handleWxUpload(String url, File file, Class<T> clazz)
    throws Exception{
        String content = null;
        try {
            HttpPost post = new HttpPost(url);
            post.setHeader("Connection", "Keep-Alive");
            post.setHeader("Cache-Control", "no-cache");
            HttpEntity entity = MultipartEntityBuilder.create().addBinaryBody("media", file,
                    ContentType.APPLICATION_OCTET_STREAM, file.getName()).build();
            post.setEntity(entity);
            CloseableHttpResponse response = client.execute(post);
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                content = EntityUtils.toString(response.getEntity());
                logger.info("weixin upload return content: " + content);
                ObjectMapper om = new ObjectMapper();
                om.registerModule(new Jdk8Module());
                return Optional.ofNullable(om.readValue(content, clazz));
            }
            else {
                //client.close()
                logger.error("http send failure");
                return Optional.empty();
            }
        }
        catch(JsonProcessingException e){
            WxException we = new WxException(content);
            we.log();
            throw we;
        }
        catch (IOException exe){
            exe.printStackTrace();
            throw exe;
        }
    }


    /***
     * 处理微信上传
     * @throws Exception
     */
    public static <T> Optional<T> handleWxUpload(
        String url, byte[] inputStream,
        String fileName, Class<T> clazz) throws Exception{
        String content = null;
        try {
            HttpPost post = new HttpPost(url);
            post.setHeader("Connection", "Keep-Alive");
            post.setHeader("Cache-Control", "no-cache");
            ContentType contentType = ContentType.MULTIPART_FORM_DATA;
            HttpEntity entity = MultipartEntityBuilder.create()
            .addBinaryBody("media", inputStream, contentType, fileName)
            .build();
            post.setEntity(entity);
            CloseableHttpResponse response = client.execute(post);
            int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                content = EntityUtils.toString(response.getEntity(), "UTF-8");
                logger.info("weixin upload return content:" + content);
                ObjectMapper om = new ObjectMapper();
                om.registerModule(new Jdk8Module());
                return Optional.ofNullable(om.readValue(content, clazz));
            }
            else {
                //client.close()
                logger.error("http send failure");
                return Optional.empty();
            }
        }
        catch(JsonProcessingException e){
            WxException we = new WxException(content);
            we.log();
            throw we;
        }
        catch (IOException exe){
            exe.printStackTrace();
            throw exe;
        }
    }


}

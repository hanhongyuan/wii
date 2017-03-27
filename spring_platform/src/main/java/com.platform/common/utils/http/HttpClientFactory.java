package com.platform.common.utils.http;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import javax.net.ssl.SSLContext;

/**
 * Created by tanghong on 2017/3/6.
 */
public class HttpClientFactory {

    public static CloseableHttpClient createDefaultClient(){
        try {
            SSLContext ssl = SSLContexts.createSystemDefault();
            SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(ssl, NoopHostnameVerifier.INSTANCE);
            return HttpClients.custom().setSSLSocketFactory(ssf).build();
        }
        catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static CloseableHttpClient createClient(int maxPerRoute, int maxTotal){
        try {
            SSLContext ssl = SSLContexts.createSystemDefault();
            SSLConnectionSocketFactory ssf = new SSLConnectionSocketFactory(ssl, NoopHostnameVerifier.INSTANCE);
            PoolingHttpClientConnectionManager pcm = new PoolingHttpClientConnectionManager();
            // max total coon 200
            pcm.setMaxTotal(maxTotal);
            // max per route 20
            pcm.setDefaultMaxPerRoute(maxPerRoute);
            return HttpClients.custom()
            .setSSLSocketFactory(ssf)
            .setConnectionManager(pcm)
            .build();
        } catch(Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

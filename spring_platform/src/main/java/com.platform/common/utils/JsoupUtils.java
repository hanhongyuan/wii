package com.platform.common.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.Optional;
import java.util.function.Function;

/**
 * Created by tanghong on 2017/3/10.
 */
public class JsoupUtils {

    public static String disposeImgUrl(String content, Function<String, Optional<String>> func){
        Document doc = Jsoup.parse(content);
        // akka 延时处理
        doc.getElementsByTag("img").stream().forEach( img -> {
            //println(img)
            Optional<String> attrOpt = Optional.of(img.attr("src"));
            String url = attrOpt.orElse(img.attr("data-src"));
            Optional<String> replaceUrlOpt = Optional.empty();
            if (url != null && !url.equals("")) {
                if (!url.contains("http://mmbiz.qpic.cn/")) {
                    replaceUrlOpt = func.apply(url);
                }
            }
            if (attrOpt.isPresent()) {
                if (replaceUrlOpt.isPresent()) {
                    String v = replaceUrlOpt.get();
                    img.attr("data-src", v);
                    img.attr("src", v);
                }
            }
            else {
                if (replaceUrlOpt.isPresent()) {
                    String v = replaceUrlOpt.get();
                    img.attr("src", v);
                }
            }
        });
        return doc.html();
    }

}

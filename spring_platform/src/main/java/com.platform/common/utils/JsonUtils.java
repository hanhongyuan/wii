package com.platform.common.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tanghong on 2017/3/7.
 */
public class JsonUtils {

    public static String writeObjAsStr(Object obj)
    throws Exception{
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new Jdk8Module());
        return om.writeValueAsString(obj);
    }

    public static <T> T readObj(String str, Class<T> clazz)
    throws Exception{
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new Jdk8Module());
        return om.readValue(str, clazz);
    }

    public static <T> List<T> readList(String str, Class<T> clazz)
            throws Exception{
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new Jdk8Module());
        CollectionType arrayType = TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, clazz);
        return om.readValue(str, arrayType);
    }
}

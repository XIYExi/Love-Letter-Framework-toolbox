package com.xion.wiki.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CopyUtil {

    public static <T> T copy(Object source, Class<T> clazz) {
        if (source == null)
            return null;
        T obj = null;
        try {
            obj = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        BeanUtils.copyProperties(source, obj);
        return obj;
    }

    public static <T> List<T> copyList(List source, Class<T> clazz){
        List<T> target = new ArrayList<>();
        if(!CollectionUtils.isEmpty(source)){
            for (Object o : source){
                T obj = copy(o, clazz);
                target.add(obj);
            }
        }
        return target;
    }


}

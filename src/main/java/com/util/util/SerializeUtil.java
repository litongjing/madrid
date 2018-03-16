package com.util.util;

import org.apache.commons.collections.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangjinhong on 17/10/29.
 */
public class SerializeUtil {


    /**
     * 序列化
     *
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        if (object == null) {
            return null;
        }

        byte[] bytes = null;
        try {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
                 ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                // 序列化
                oos.writeObject(object);
                bytes = baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

    /**
     * 反序列化
     *
     * @param bytes
     * @return
     */
    public static Object unserialize(byte[] bytes) {
        if (bytes == null) {
            return null;
        }

        try {
            try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes); ObjectInputStream ois = new ObjectInputStream(bais)) {
                // 反序列化
                return ois.readObject();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        return null;
    }

    public static <T> byte[] serializeList(List<T> list) {

        if (CollectionUtils.isEmpty(list)) {
            return null;
        }

        byte[] bytes = null;
        try {
            try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                for (Object obj : list) {
                    oos.writeObject(obj);
                }
                bytes = baos.toByteArray();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

    /**
     * 反序列化 list 集合
     *
     * @return
     */
    public static <T> List<T> unserializeList(byte[] bytes) {
        if (bytes == null) {
            return null;
        }

        List<T> list = new ArrayList<T>();

        try {
            try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
                 ObjectInputStream ois = new ObjectInputStream(bais)) {
                while (bais.available() > 0) {
                    T obj = (T) ois.readObject();
                    if (obj == null) {
                        break;
                    }
                    list.add(obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        return list;
    }


}
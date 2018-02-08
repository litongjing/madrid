package com.dao.redisDemo;

import com.designpattern.builder.Person;
import com.domain.DO.CouponDO;
import com.util.ProroBufUtil;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Date;

import static io.protostuff.runtime.RuntimeSchema.getSchema;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午7:23 2018/1/21
 */
public class RedisDemo {

    private final JedisPool jedisPool;

    public RedisDemo(String ip, int port) {
        jedisPool = new JedisPool(ip, port);
    }

    public Person getPerson(String name) {
        byte[] bytes = null;
        try {
            Jedis jedis = jedisPool.getResource();
            jedis.auth("intimednb");
            String key = "person:" + name;
            bytes = jedis.get(key.getBytes());
        } finally {
            jedisPool.close();
        }
        Person person = (Person) ByteToObject(bytes);
        return person;
    }

    public void setPerson(Person person) {
        try {
            Jedis jedis = jedisPool.getResource();
            jedis.auth("intimednb");
            String key = "person:" + person.getName();
            System.out.println(jedis.set(key.getBytes(), ObjectToByte(person)));
        } finally {
            jedisPool.close();
        }
    }

    public static Object ByteToObject(byte[] bytes) {
        Object obj = null;
        try {
            // bytearray to object
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);

            obj = oi.readObject();
            bi.close();
            oi.close();
        } catch (Exception e) {
            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return obj;
    }


    public static byte[] ObjectToByte(java.lang.Object obj) {
        byte[] bytes = null;
        try {
            // object to bytearray
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);

            bytes = bo.toByteArray();

            bo.close();
            oo.close();
        } catch (Exception e) {
            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return bytes;
    }

    public static void main(String[] args) {
        Person person = new Person.Builder().setAge(18).setName("litongjing").setPhone("188").build();
//        RedisDemo redisDemo = new RedisDemo("192.168.130.7", 6379);
//        redisDemo.setPerson(person);
//        redisDemo = new RedisDemo("192.168.130.7", 6379);
//        System.out.println(redisDemo.getPerson("litongjing"));

        long start1=System.currentTimeMillis();
        byte[] b1=RedisDemo.ObjectToByte(person);
        long start2=System.currentTimeMillis();
        System.out.println(Arrays.toString(b1));
        long start3=System.currentTimeMillis();
        System.out.println(RedisDemo.ByteToObject(b1));
        long start4=System.currentTimeMillis();



        long start5=System.currentTimeMillis();
        byte[] b2=ProroBufUtil.serializer(person);
        long start6=System.currentTimeMillis();
        System.out.println(Arrays.toString(ProroBufUtil.serializer(person)));
        long start7=System.currentTimeMillis();
        System.out.println(ProroBufUtil.deserializer(b2,Person.class));
        long start8=System.currentTimeMillis();
        System.out.println(start2-start1);
        System.out.println(start4-start3);
        System.out.println(start6-start5);
        System.out.println(start8-start7);
    }
}
